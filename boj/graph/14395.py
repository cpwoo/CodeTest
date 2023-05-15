import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

MAX = int(1e9)

s, t = map(int, input().split())

if s == t:
    print(0)
    exit()

q = deque()
q.append((s, ""))

visited = set()
visited.add(s)

while q:
    cur, op = q.popleft()
    if cur == t:
        print(op)
        exit()
    
    nxt = cur*cur
    if 0 <= nxt <= MAX and nxt not in visited:
        q.append((nxt, op+"*"))
        visited.add(nxt)
    
    nxt = cur+cur
    if 0 <= nxt <= MAX and nxt not in visited:
        q.append((nxt, op+"+"))
        visited.add(nxt)

    nxt = 1
    if nxt not in visited:
        q.append((nxt, op+"/"))
        visited.add(nxt)

print(-1)
