import sys
def input(): return sys.stdin.readline().rstrip()

from collections import deque

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
inDegree = [0]*(n+1)
q = deque()
answer = []

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    inDegree[b] += 1
    
for i in range(1, n+1):
    if inDegree[i] == 0:
        q.append(i)
        
while q:
    tmp = q.popleft()
    answer.append(tmp)
    for i in graph[tmp]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            q.append(i)
            
print(*answer)
