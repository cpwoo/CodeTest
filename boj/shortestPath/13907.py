import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

def dijkstra(v):
    global ans
    d[v][0] = 0
    q = []
    q.append((d[v][0], v, 0))
    while q:
        cur_dist, cur_node, visited = heappop(q)
        flag = False
        
        for i in range(visited):
            if d[cur_node][i] < cur_dist:
                flag = True
                break

        if flag or d[cur_node][visited] < cur_dist: continue

        if cur_node == e-1: 
            ans = min(ans, d[cur_node][visited])
            continue

        for nxt_node, nxt_dist in graph[cur_node]:
            dist = cur_dist+nxt_dist
            if visited+1 < n and dist < d[nxt_node][visited+1]:
                d[nxt_node][visited+1] = dist
                heappush(q, (dist, nxt_node, visited+1))


n, m, k = map(int, input().split())
s, e = map(int, input().split())

graph = [[] for _ in range(n)]
for _ in range(m):
    a, b, w = map(int, input().split())
    a -= 1; b -= 1
    graph[a].append((b, w))
    graph[b].append((a, w))

tax = [int(input()) for _ in range(k)]
d = [[INF]*n for _ in range(n)]

ans = INF
dijkstra(s-1)
print(ans)

for t in tax:
    for j in range(n):
        if d[e-1][j] != INF:
            d[e-1][j] = d[e-1][j] + t*j
    print(min(d[e-1]))
