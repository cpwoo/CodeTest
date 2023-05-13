import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

def dijkstra():
    d[1] = 0
    heappush(q, (0, 1))

    while q:
        cur_w, cur_node = heappop(q)
        
        if d[cur_node] < cur_w: continue
        
        for nxt_node, nxt_w in graph[cur_node]:
            cost = cur_w + nxt_w

            if d[nxt_node] > cost:
                d[nxt_node] = cost
                heappush(q, (cost, nxt_node))


n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
d = [INF]*(n+1)
q = []

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

dijkstra()
print(d[n])
