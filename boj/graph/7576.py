import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

m, n = map(int, input().split())
matrix = []
q = deque()

for i in range(n):
    matrix.append(list(map(int, input().split())))
    for j in range(m):
        if matrix[i][j] == 1:
            q.append([i, j])

while q:
    x, y = q.popleft()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if (0 <= nx < n) and (0 <= ny < m) and matrix[nx][ny] == 0:
            q.append([nx, ny])
            matrix[nx][ny] = matrix[x][y]+1

res = 0
for i in matrix:
    for j in i:
        if j == 0:
            print(-1)
            exit()
    res = max(res, max(i))

print(res-1)
