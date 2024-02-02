import sys
input = lambda : sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

def dijkstra(s, e):
    q = []
    heappush(q, (0, s))
    
    distance = [INF]*(V+1)
    distance[s] = 0

    while q:
        cur_cost, cur_node = heappop(q)
        
        if distance[cur_node] < cur_cost:
            continue

        for nxt_node, nxt_cost in graph[cur_node]:
            cost = cur_cost + nxt_cost
            if distance[nxt_node] > cost:
                distance[nxt_node] = cost
                heappush(q, (cost, nxt_node))
    
    return distance[e]


V, E, P = map(int, input().split())

graph = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))
    graph[v].append((u, w))
    
print("SAVE HIM" if dijkstra(1, P) + dijkstra(P, V) <= dijkstra(1, V) else "GOOD BYE")
