import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from itertools import combinations

INF = sys.maxsize

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
            if (0 <= nx < N) and (0 <= ny < N):
                if visited[nx][ny] == -1 and Lab[nx][ny] == 0:
                    q.append([nx, ny])
                    visited[nx][ny] = visited[x][y] + 1
                    m = max(m, visited[nx][ny])
                elif visited[nx][ny] == -1 and Lab[nx][ny] == 2:
                    q.append([nx, ny])
                    visited[nx][ny] = visited[x][y] + 1
    
    if list(sum(visited, [])).count(-1) != wall_cnt:
        return INF

    return m


N, M = map(int, input().split())
Lab = []
virus = []
wall_cnt = 0
for i in range(N):
    Lab.append(list(map(int, input().split())))
    for j in range(N):
        if Lab[i][j] == 2:
            virus.append([i, j])
        elif Lab[i][j] == 1:
            wall_cnt += 1

# 이미 퍼진 경우 예외 처리 Code
if len(virus)+wall_cnt == N*N:
    print(0)
    exit()

answer = INF
for v in combinations(virus, M):
    answer = min(answer, bfs(v))

print(answer if answer != INF else -1)
