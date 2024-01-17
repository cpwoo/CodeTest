import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v, cost = map(int, input().split())
    graph[u].append((v, cost))
    graph[v].append((u, cost))


s, t = map(int, input().split())
q = []
heappush(q, (0, s))

distance = [INF]*(n+1)
distance[s] = 0

while q:
    cur_cost, cur_node = heappop(q)
    
    if distance[cur_node] < cur_cost:
        continue

    for nxt_node, nxt_cost in graph[cur_node]:
        cost = cur_cost+nxt_cost
        if distance[nxt_node] > cost:
            distance[nxt_node] = cost
            heappush(q, (cost, nxt_node))

print(distance[t])
