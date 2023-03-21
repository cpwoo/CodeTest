import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(start):
    q = []
    distance[start] = 0
    heappush(q, [0, start])

    while q:
        dist, now = heappop(q)

        if distance[now] < dist:
            continue

        for nxt_node, nxt_cost in graph[now]:
            cost = dist + nxt_cost

            if distance[nxt_node] > cost:
                parent[nxt_node] = now
                distance[nxt_node] = cost
                heappush(q, [cost, nxt_node])


n, m = map(int, input().split())

distance = [int(1e9)]*(n+1)
parent = [0]*(n+1)
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

dijkstra(1)

print(n-1)
for i in range(2, n+1):
    print(i, parent[i])
