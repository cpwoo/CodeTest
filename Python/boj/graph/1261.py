import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

M, N = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]
d = [[-1]*M for _ in range(N)]

q = deque()
q.append([0, 0])
d[0][0] = 0

while q:
    x, y = q.popleft()
    for k in range(4):
        nx, ny = x+dx[k], y+dy[k]
        if (0 <= nx < N) and (0 <= ny < M):
            if d[nx][ny] == -1:
                if board[nx][ny] == 0:
                    d[nx][ny] = d[x][y]
                    q.appendleft([nx, ny])
                else:
                    d[nx][ny] = d[x][y] + 1
                    q.append([nx, ny])

print(d[N-1][M-1])
