import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n, m = map(int, input().split())

answer = []
graph = [[] for _ in range(n+1)]
inDegree = [0] * (n+1)
q = []

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    inDegree[b] += 1
    
for i in range(1, n+1):
    if inDegree[i] == 0:
        heappush(q, i)
        
while q:
    tmp = heappop(q)
    answer.append(tmp)
    for i in graph[tmp]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            heappush(q, i)
        
print(*answer)
