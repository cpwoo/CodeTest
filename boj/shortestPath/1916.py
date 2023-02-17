import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(node):
    d[node] = 0
    q = []
    heappush(q, (0, node))
    
    while q:
        w, cur = heappop(q)
        if d[cur] < w:
            continue
        for nxt, wei in graph[cur]:
            cost = d[cur] + wei
            if d[nxt] > cost:
                d[nxt] = cost
                heappush(q, (cost, nxt))


N, M = int(input()), int(input())
graph = [[] for _ in range(N+1)]
d = [int(1e9)]*(N+1)
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())

dijkstra(start)
print(d[end])
