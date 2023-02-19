import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

# 3차원 bfs
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def bfs():
    q = deque()
    q.append([sz, sx, sy])
    visited[sz][sx][sy] = True
    while q:
        z, x, y = q.popleft()
        for d in range(6):
            nz, nx, ny = z+dz[d], x+dx[d], y+dy[d]
            if (0 <= nz < L) and (0 <= nx < R) and (0 <= ny < C) and not visited[nz][nx][ny]:
                if m[nz][nx][ny] == "." or m[nz][nx][ny] == "E":
                    time[nz][nx][ny] = time[z][x][y]+1
                    q.append([nz, nx, ny])
                    visited[nz][nx][ny] = True


while True:
    L, R, C = map(int, input().split())
    if (L, R, C) == (0, 0, 0): break

    m = [[]*R for _ in range(L)]
    time = [[[0]*C for _ in range(R)] for _ in range(L)]
    visited = [[[False]*C for _ in range(R)] for _ in range(L)]

    for i in range(L):
        for _ in range(R):
            m[i].append(list(input()))
        input()

    for k in range(L):
        for i in range(R):
            for j in range(C):
                if m[k][i][j] == "S":
                    sz, sx, sy = k, i, j
                elif m[k][i][j] == "E":
                    ez, ex, ey = k, i, j

    bfs()
    if time[ez][ex][ey]:
        print("Escaped in {} minute(s).".format(str(time[ez][ex][ey])))
    else:
        print("Trapped!")
