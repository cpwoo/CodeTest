import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(i, j):
    q = deque()
    q.append((i, j))
    tmp = []
    tmp.append((i, j))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < N) and (0 <= ny < N) and not visited[nx][ny]:
                if L <= abs(graph[nx][ny]-graph[x][y]) <= R:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                    tmp.append((nx, ny))
    return tmp

N, L, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
cnt = 0

while True:
    visited = [[0]*N for _ in range(N)]
    flag = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                visited[i][j] = 1
                tmp = bfs(i, j)
                if len(tmp) > 1:
                    flag = True
                    num = sum([graph[x][y] for x,y in tmp]) // len(tmp)
                    for x,y in tmp:
                        graph[x][y] = num
    if not flag: break
    cnt += 1

print(cnt)
