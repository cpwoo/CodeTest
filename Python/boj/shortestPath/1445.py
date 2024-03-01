import sys
input = lambda : sys.stdin.readline().rstrip()

from heapq import *

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]

for i in range(N):
    for j in range(M):
        if board[i][j] == "S":
            sx, sy = i, j
        elif board[i][j] == "F":
            fx, fy = i, j
        elif board[i][j] == "g":
            for d in range(4):
                ni, nj = i+dx[d], j+dy[d]
                if (0 <= ni < N) and (0 <= nj < M) and board[ni][nj] == ".":
                    board[ni][nj] = "p"


q = []
heappush(q, (0, 0, sx, sy))

dist = [[-1]*M for _ in range(N)]
dist[sx][sy] = 0

while q:
    g, p, x, y = heappop(q)
    
    if (x, y) == (fx, fy):
        print(g, p)
        break

    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < N) and (0 <= ny < M) and dist[nx][ny] == -1:
            if board[nx][ny] == "g":
                heappush(q, (g+1, p, nx, ny))
            elif board[nx][ny] == "p":
                heappush(q, (g, p+1, nx, ny))
            else:
                heappush(q, (g, p, nx, ny))
            dist[nx][ny] = dist[x][y]+1
