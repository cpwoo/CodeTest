import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n, m = map(int, input().split())
k = int(input())

arr = [0]*(k+1)

adj = [[] for _ in range(k+1)]

for _ in range(k):
    a, b, c, d, e = map(int, input().split())
    arr[a] = (min(b,d), min(c,e), max(b,d), max(c,e))

check = [False]*(k+1)
for i in range(1, k+1):
    tmp = False
    x1, y1, x2, y2 = arr[i]
    
    for j in range(1, k+1):
        if i == j: continue
        x3, y3, x4, y4 = arr[j]
        
        if x1 == x2 == x3 == x4:
            if y3 <= y1 <= y2 <= y4:
                tmp = True
        
        if y1 == y2 == y3 == y4:
            if x3 <= x1 <= x2 <= x4:
                tmp = True
    
    check[i] = tmp

for i in range(1, k+1):
    if check[i]: continue
    x1, y1, x2, y2 = arr[i]
    
    for j in range(1, k+1):
        if check[j]: continue
        if i == j: continue
        x3, y3, x4, y4 = arr[j]

        if x1 <= x3 <= x2 and x1 <= x4 <= x2:
            if y3 <= y1 <= y4 and y3 <= y2 <= y4:
                adj[i].append(j)
                adj[j].append(i)
        
        if x1 == x2 == x3 == x4:
            if not (y1 > y4 or y2 < y3):
                adj[i].append(j)
                adj[j].append(i)

        if y1 == y2 == y3 == y4:
            if not (x1 > x4 or x2 < x3):
                adj[i].append(j)
                adj[j].append(i)


sx, sy, ex, ey = map(int, input().split())

start, end = [], []

for i in range(1, k+1):
    if check[i]: continue
    x1, y1, x2, y2 = arr[i]
    if x1 <= sx <= x2 and y1 <= sy <= y2:
        start.append(i)
    if x1 <= ex <= x2 and y1 <= ey <= y2:
        end.append(i)

q = deque()
visited = [-1]*(k+1)
for i in start:
    q.append(i)
    visited[i] = 0

while q:
    now = q.popleft()
    for nxt in adj[now]:
        if visited[nxt] == -1:
            visited[nxt] = visited[now]+1
            q.append(nxt)

ans = int(1e9)
for i in end:
    ans = min(ans, visited[i])

print(ans+1)
