import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(start):
    dist[start] = 0
    heappush(q, (0, start))

    while q:
        cur_w, cur_node = heappop(q)

        if dist[cur_node] < cur_w: continue

        for nxt_node, nxt_w in graph[cur_node]:
            cost = cur_w + nxt_w

            if dist[nxt_node] > cost:
                dist[nxt_node] = cost
                heappush(q, (cost, nxt_node))


v, e = map(int, input().split())
k = int(input())
graph = [[] for _ in range(v+1)]
dist = [int(1e9)] * (v+1)
q = []

for _ in range(e):
    a, b, w = map(int, input().split())
    graph[a].append((b, w))

dijkstra(k)

for i in dist[1:]:
    print(i if i != int(1e9) else "INF")
