import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

def direction(s):
    if s == "|":
        return [1,3]
    elif s == "-":
        return [0,2]
    elif s == "+" or s == "M" or s == "Z":
        return [0,1,2,3]
    elif s == "1":
        return [0,1]
    elif s == "2":
        return [0,3]
    elif s == "3":
        return [2,3]
    elif s == "4":
        return [1,2]

def bfs(x, y, direc):
    global fx, fy
    q = deque()
    q.append((x, y, direc))
    c[x][y] = 1
    while q:
        x, y, direc = q.popleft()
        for d in direc:
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < m) and (0 <= ny < n) and not c[nx][ny]:
                if a[nx][ny] != ".":
                    c[nx][ny] = 1
                    ndirec = direction(a[nx][ny])
                    q.append((nx, ny, ndirec))
                else:
                    if a[x][y] == "M" or a[x][y] == "Z":
                        continue
                    if (fx, fy) == (0, 0):
                        fx, fy = nx+1, ny+1
                    nd = (d+2)%4
                    if nd not in chk:
                        chk.append(nd)


m, n = map(int, input().split())
c = [[0]*n for _ in range(m)]

a = []
for i in range(m):
    row = list(input())
    a.append(row)
    for j in range(n):
        if row[j] == "M":
            sx, sy = i, j
        if row[j] == "Z":
            ex, ey = i, j

chk = []
fx, fy = 0, 0
bfs(sx, sy, [0,1,2,3])
bfs(ex, ey, [0,1,2,3])

for i in range(m):
    for j in range(n):
        if a[i][j] != "." and not c[i][j]:
            bfs(i, j, direction(a[i][j]))
chk.sort()

if len(chk) == 4:
    print(fx, fy, "+")
else:
    block = ["|", "-", "1", "2", "3", "4"]
    for b in block:
        if chk == direction(b):
            print(fx, fy, b)
