import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx = [0, 0, 1, -1, 1, -1, 1, -1, 0]
dy = [1, -1, 0, 0, 1, 1, -1, -1, 0]

n = 8
graph = [list(input().rstrip()) for _ in range(n)]
visited = [[False] * n for _ in range(n)]

q = deque()
q.append((7, 0))
visited[7][0] = True
ans = 0
while q:
    i, j = q.popleft()
    if graph[i][j] == '#':
        continue
    for idx in range(n+1):
        ni, nj = i+dy[idx], j+dx[idx]
        if not (0 <= ni < n and 0 <= nj < n) or graph[ni][nj] == '#':
            continue
        if ni == 0:
            ans = 1
        if not visited[ni-1][nj]:
            visited[ni-1][nj] = True
            q.append((ni-1, nj))

print(ans)
