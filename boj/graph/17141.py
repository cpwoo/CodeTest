import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from itertools import combinations

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(v):
    q = deque(v)
    visited = [[-1]*N for _ in range(N)]
    m = 0
    for x, y in q:
        visited[x][y] = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < N) and (0 <= ny < N) and visited[nx][ny] == -1 and Lab[nx][ny] != 1:
                q.append([nx, ny])
                visited[nx][ny] = visited[x][y] + 1
                m = max(m, visited[x][y]+1)
    
    for i in range(N):
        for j in range(N):
            if visited[i][j] == -1 and Lab[i][j] != 1:
                return int(1e9)

    return m


N, M = map(int, input().split())
Lab = []
virus = []
for i in range(N):
    Lab.append(list(map(int, input().split())))
    for j in range(N):
        if Lab[i][j] == 2:
            virus.append([i, j])

answer = int(1e9)
for v in combinations(virus, M):
    answer = min(answer, bfs(v))

print(answer if answer != int(1e9) else -1)
