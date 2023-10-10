import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

m, n, h = map(int, input().split())
matrix = []
q = deque()

for i in range(h):
    tmp = []
    for j in range(n):
        tmp.append(list(map(int, input().split())))
        for k in range(m):
            if tmp[j][k] == 1:
                q.append([i, j, k])
    matrix.append(tmp)

while q:
    z, x, y = q.popleft()
    for i in range(6):
        nz, nx, ny = z+dz[i], x+dx[i], y+dy[i]
        if (0 <= nz < h) and (0 <= nx < n) and (0 <= ny < m) and matrix[nz][nx][ny] == 0:
            q.append([nz, nx, ny])
            matrix[nz][nx][ny] = matrix[z][x][y]+1

res = 0
for i in matrix:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit()
        res = max(res, max(j))

print(res-1)
