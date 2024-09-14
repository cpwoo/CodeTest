import sys
def input(): return sys.stdin.readline().rstrip()

from collections import deque

def bfs(a, b, c):
    total = a+b+c
    visited = [[False]*(total+1) for _ in range(total+1)]
    q = deque()
    q.append([a, b])
    visited[a][b] = True
    while q:
        x, y = q.popleft()
        z = total - (x+y)
        if x == y == z:
            return 1
        for a, b in (x, y), (y, z), (x, z):
            if a < b:
                b -= a
                a += a
            elif a > b:
                a -= b
                b += b
            else:
                continue
            c = total - (a+b)
            x = min(a, b, c)
            y = max(a, b, c)
            if not visited[x][y]:
                q.append([x, y])
                visited[x][y] = True
    return 0


a, b, c = map(int, input().split())

if (a+b+c)%3 != 0:
    print(0)
else:
    print(bfs(a, b, c))
