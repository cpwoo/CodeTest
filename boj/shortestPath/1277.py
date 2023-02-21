import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dist(x1, y1, x2, y2):
    return ((x1-x2)**2 + (y1-y2)**2)**0.5

def dijkstra():
    distance = [INF] * (n+1)
    distance[1] = 0
    q = []
    heappush(q, (0, 1))

    while q:
        cur_cost, cur_node = heappop(q)
        
        if distance[cur_node] < cur_cost:
            continue

        for nxt_node, nxt_cost in graph[cur_node]:
            cost = cur_cost + nxt_cost
            if distance[nxt_node] > cost:
                distance[nxt_node] = cost
                heappush(q, (cost, nxt_node))
    
    return int(distance[n]*1000)


INF = sys.maxsize
n, w = map(int, input().split())
m = float(input())
graph = [[] for _ in range(n+1)]
pos = [[0, 0]] + [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n+1):
    for j in range(1, n+1):
        d = dist(pos[i][0], pos[i][1], pos[j][0], pos[j][1])
        if d <= m:
            graph[i].append((j, d))
            graph[j].append((i, d))

for _ in range(w):
    a, b = map(int, input().split())
    graph[a].append((b, 0))
    graph[b].append((a, 0))

print(dijkstra())
