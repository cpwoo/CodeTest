import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

n = int(input())
board = [list(input()) for _ in range(n)]

door = []
for i in range(n):
    for j in range(n):
        if board[i][j] == "#":
            door.append([i, j])

sx, sy, ex, ey = door[0][0], door[0][1], door[1][0], door[1][1]

q = deque()
for d in range(4):
    q.append([sx, sy, d])

visited = [[[-1]*4 for _ in range(n)] for _ in range(n)]
for d in range(4):
    visited[sx][sy][d] = 0

while q:
    x, y, d = q.popleft()
    if (x, y) == (ex, ey):
        print(visited[ex][ey][d])
        break
    nx, ny = x+dx[d], y+dy[d]
    if (0 <= nx < n) and (0 <= ny < n):
        if board[nx][ny] != "*":
            if visited[nx][ny][d] == -1 or visited[nx][ny][d] > visited[x][y][d]:
                visited[nx][ny][d] = visited[x][y][d]
                q.appendleft([nx, ny, d])
            if board[nx][ny] == "!":
                if d < 2:
                    for nd in [2,3]:
                        if visited[nx][ny][nd] == -1 or visited[nx][ny][nd] > visited[x][y][d]+1:
                            visited[nx][ny][nd] = visited[x][y][d]+1
                            q.append([nx, ny, nd])
                else:
                    for nd in [0,1]:
                        if visited[nx][ny][nd] == -1 or visited[nx][ny][nd] > visited[x][y][d]+1:
                            visited[nx][ny][nd] = visited[x][y][d]+1
                            q.append([nx, ny, nd])
