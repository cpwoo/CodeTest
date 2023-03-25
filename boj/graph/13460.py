import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def move(x, y, dx, dy):
    cnt = 0
    while board[x+dx][y+dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        cnt += 1
    return x, y, cnt


n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

q = deque()
visited = [[[[False for _ in range(m)] for _ in range(n)] for _ in range(m)] for _ in range(n)]

rx, ry, bx, by = 0, 0, 0, 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 'R':
            rx, ry = i, j
        elif board[i][j] == 'B':
            bx, by = i, j
q.append((rx, ry, bx, by, 1))
visited[rx][ry][bx][by] = True

while q:
    rx, ry, bx, by, depth = q.popleft()
    if depth > 10:
        break
    for i in range(4):
        nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
        nbx, nby, bcnt = move(bx, by, dx[i], dy[i])
        if board[nbx][nby] != 'O':
            if board[nrx][nry] == 'O':
                print(depth)
                exit()
            if nrx == nbx and nry == nby:
                if rcnt > bcnt:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]
            if not visited[nrx][nry][nbx][nby]:
                visited[nrx][nry][nbx][nby] = True
                q.append((nrx, nry, nbx, nby, depth+1))
print(-1)
