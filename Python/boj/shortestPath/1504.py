import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(start, end):
    distance = [int(1e9)] * (N+1)
    distance[start] = 0
    
    q = []
    heappush(q, [0, start])

    while q:
        dist, now = heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]

            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heappush(q, [cost, i[0]])
    
    return distance[end]

N, E = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

v1, v2 = map(int, input().split())

path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N)
path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N)

if path1 >= int(1e9) and path2 >= int(1e9):
    print(-1)
else:
    print(min(path1, path2))
