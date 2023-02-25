import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = int(1e9)

def dijkstra(start):
    q = []
    distance = [INF] * (N+1)
    
    heappush(q, [0, start])
    distance[start] = 0
    
    while q:
        dist, now = heappop(q)
        
        if distance[now] < dist:
            continue
            
        for node_index, node_cost in graph[now]:
            cost = dist + node_cost
            
            if distance[node_index] > cost:
                distance[node_index] = cost
                heappush(q, [cost, node_index])
    return distance


N, M, X = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, cost = map(int, input().split())
    graph[a].append([b, cost])
    
result = 0
for i in range(1, N+1):
    go = dijkstra(i)
    back = dijkstra(X)
    result = max(result, go[X] + back[i])
    
print(result)
