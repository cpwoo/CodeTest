import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

def bfs(x, y):
    q.append([x, y])
    c[x][y] = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx <= 2000 and 0 <= ny <= 2000:
                if a[nx][ny] == 1 and c[nx][ny] == 0:
                    c[nx][ny] = 1
                    q.append([nx, ny])

n = int(input())
a = [[0]*2001 for _ in range(2001)]
c = [[0]*2001 for _ in range(2001)]
start = []
for _ in range(n):
    x1, y1, x2, y2 = map(lambda t: (int(t)+500)*2, input().split())
    start.append([x1, y1])
    for i in range(x1, x2+1):
        if i == x1 or i == x2:
            for j in range(y1, y2+1):
                a[i][j] = 1
        else:
            a[i][y1] = 1
            a[i][y2] = 1

q = deque()
ans = 0
for i in range(n):
    x, y = start[i]
    if c[x][y] == 0:
        bfs(x, y)
        ans += 1

if a[1000][1000] == 1:
    ans -= 1
print(ans)
