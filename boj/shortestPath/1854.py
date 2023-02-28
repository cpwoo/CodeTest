import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = int(1e9)

def dijkstra(start):
    q = []
    distance = [[INF]*k for _ in range(n+1)]

    heappush(q, (0, start))
    distance[start][0] = 0

    while q:
        cur_cost, cur_idx = heappop(q)

        for nxt_idx, nxt_cost in graph[cur_idx]:
            cost = cur_cost + nxt_cost

            if distance[nxt_idx][k-1] > cost:
                distance[nxt_idx][k-1] = cost
                distance[nxt_idx].sort()
                heappush(q, (cost, nxt_idx))
    return distance


n, m, k = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

distance = dijkstra(1)

for i in range(1, n+1):
    print(distance[i][k-1] if distance[i][k-1] != INF else -1)
