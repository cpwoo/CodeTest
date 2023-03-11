from collections import deque

n, m = map(int, input().split())
inDegree = [0]*(n+1)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    tmp = list(map(int, input().split()))
    for i in range(1, tmp[0]):
        graph[tmp[i]].append(tmp[i+1])
        inDegree[tmp[i+1]] += 1
        
answer = []
q = deque()

for i in range(1, n+1):
    if inDegree[i] == 0:
        q.append(i)
        
while q:
    tmp = q.popleft()
    answer.append(tmp)
    
    for e in graph[tmp]:
        inDegree[e] -= 1
        if inDegree[e] == 0:
            q.append(e)
            
if len(answer) == n:
    for i in answer:
        print(i)
else:
    print(0)
