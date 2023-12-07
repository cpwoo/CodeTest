import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

a, b, c, d = map(int, input().split())

visited = set()
visited.add((0, 0))

q = deque()
q.append((0, 0, 0))

while q:
    cnt, x, y = q.popleft()
    if (x, y) == (c, d):
        print(cnt)
        break
    # F(x)
    if x < a and (a, y) not in visited:
        visited.add((a, y))
        q.append((cnt+1, a, y))
    # F(y)
    if y < b and (x, b) not in visited:
        visited.add((x, b))
        q.append((cnt+1, x, b))
    # E(x)
    if x and (0, y) not in visited:
        visited.add((0, y))
        q.append((cnt+1, 0, y))
    # E(y)
    if y and (x, 0) not in visited:
        visited.add((x, 0))
        q.append((cnt+1, x, 0))
    # M(x, y)
    k = min(x, b-y)
    if x and k and (x-k, y+k) not in visited:
        visited.add((x-k, y+k))
        q.append((cnt+1, x-k, y+k))
    # M(y, x)
    k = min(y, a-x)
    if y and k and (x+k, y-k) not in visited:
        visited.add((x+k, y-k))
        q.append((cnt+1, x+k, y-k))
else:
    print(-1)
