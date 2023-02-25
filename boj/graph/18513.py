import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n, k = map(int, input().split())
lake = list(map(int, input().split()))
q = deque()
visited = dict()

for l in lake:
    q.append(l)
    visited[l] = 0
    
while q:
    if k <= 0:
        break
    x = q.popleft()
    for nx in [x-1, x+1]:
        if nx not in visited and k > 0:
            visited[nx] = visited[x]+1
            k -= 1
            q.append(nx)
            
result = 0
for k, v in visited.items():
    result += v
print(result)
