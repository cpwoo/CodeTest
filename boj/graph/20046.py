import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

dy, dx = [1, -1, 0, 0], [0, 0, 1, -1]
m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
visited = [[int(1e9)]*n for _ in range(m)]
visited[0][0] = board[0][0]

q = []
heappush(q, [board[0][0], 0, 0])

if board[0][0] == -1:
    print(-1)
    exit()

while q:
    t, y, x = heappop(q)
    for i in range(4):
        ny, nx = y+dy[i], x+dx[i]
        if (0 <= ny < m) and (0 <= nx < n) and board[ny][nx] != -1 and visited[ny][nx] > t+board[ny][nx]:
            visited[ny][nx] = t+board[ny][nx]
            heappush(q, [visited[ny][nx], ny, nx])

print(visited[-1][-1] if visited[-1][-1] != int(1e9) else -1)
