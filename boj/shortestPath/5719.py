import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from heapq import *
INF = int(1e9)

def dijkstra():
    q = []
    heappush(q, (0, s))
    distance[s] = 0

    while q:
        dist, now = heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + graph[now][i]
            if cost < distance[i]:
                distance[i] = cost
                heappush(q, (cost, i))

def bfs():
    q = deque()
    q.append(d)
    while q:
        v = q.popleft()
        if v == s:
            continue
        for pre_v, pre_c in r_graph[v]:
            if distance[pre_v] + graph[pre_v][v] == distance[v]:
                if (pre_v, v) not in remove_lst:
                    remove_lst.append((pre_v, v))
                    q.append(pre_v)


while True:
    n, m = map(int, input().split())
    if (n, m) == (0, 0):
        break
    s, d = map(int, input().split())
    graph = [dict() for _ in range(n)]
    r_graph = [[] for _ in range(n)]
     
    for _ in range(m):
        u, v, p = map(int, input().split())
        graph[u][v] = p
        r_graph[v].append((u, p))

    distance = [INF] * n
    dijkstra()

    remove_lst = []
    bfs()

    for u, v in remove_lst:
        del graph[u][v]

    distance = [INF] * n
    dijkstra()
    print(-1 if distance[d] == INF else distance[d])
