import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    cnt = 1
    while q:
        for _ in range(len(q)):
            rx, ry, bx, by = q.popleft()
            for i in range(4):
                nrx, nry, nbx, nby = rx, ry, bx, by
                while True:
                    nrx += dx[i]
                    nry += dy[i]
                    if board[nrx][nry] == "O":
                        break
                    if board[nrx][nry] == "#":
                        nrx -= dx[i]
                        nry -= dy[i]
                        break
                while True:
                    nbx += dx[i]
                    nby += dy[i]
                    if board[nbx][nby] == "O":
                        break
                    if board[nbx][nby] == "#":
                        nbx -= dx[i]
                        nby -= dy[i]
                        break
                if board[nbx][nby] == "O":
                    continue
                if board[nrx][nry] == "O":
                    return cnt
                
                if (nrx, nry) == (nbx, nby):
                    if abs(nrx-rx) + abs(nry-ry) > abs(nbx-bx) + abs(nby-by):
                        nrx -= dx[i]
                        nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]
                
                if not visited[nrx][nry][nbx][nby]:
                    visited[nrx][nry][nbx][nby] = 1
                    q.append((nrx, nry, nbx, nby))
        cnt += 1
    return -1    


n, m = map(int, input().split())

board = []
for i in range(n):
    row = list(input())
    board.append(row)
    for j in range(m):
        if board[i][j] == "B":
            bx, by = i, j
            board[i][j] = "."
        elif board[i][j] == "R":
            rx, ry = i, j
            board[i][j] = "."

q = deque()
visited = [[[[0 for _ in range(m)] for _ in range(n)] for _ in range(m)] for _ in range(n)]
q.append((rx, ry, bx, by))
visited[rx][ry][bx][by] = 1

print(bfs())
