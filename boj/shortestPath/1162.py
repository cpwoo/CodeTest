import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

def dijkstra(start):
    q = []
    cnt = 0
    dist[start][cnt] = 0
    heappush(q, (0, start, cnt))

    while q:
        wei, now, cnt = heappop(q)
        if dist[now][cnt] < wei:
            continue
        for w, nxt_node in graph[now]:
            nxt_wei = w + wei
            if dist[nxt_node][cnt] > nxt_wei:
                dist[nxt_node][cnt] = nxt_wei
                heappush(q, (nxt_wei, nxt_node, cnt))
            
            if cnt < k and dist[nxt_node][cnt+1] > wei:
                dist[nxt_node][cnt+1] = wei
                heappush(q, (wei, nxt_node, cnt+1))


n, m, k = map(int, input().split())

graph = [[] for _ in range(n+1)]
dist = [[INF]*(k+1) for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

dijkstra(1)
print(min(dist[n]))
