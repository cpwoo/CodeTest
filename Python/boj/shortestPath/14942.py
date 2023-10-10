import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

def dijkstra(v):
    d[v] = 0
    q = [(d[v], v)]
    while q:
        cur_dist, cur_node = heappop(q)
        if d[cur_node] < cur_dist:
            continue
        for nxt_node, nxt_dist in graph[cur_node]:
            dist = cur_dist+nxt_dist
            if dist < d[nxt_node]:
                d[nxt_node] = dist
                path[nxt_node].append(cur_node)
                heappush(q, (dist, nxt_node))
                        

n = int(input())
arr = [int(input()) for _ in range(n)]

graph = [[] for _ in range(n)]
for _ in range(n-1):
    a, b, c = map(int, input().split())
    a -= 1; b -= 1
    graph[a].append((b, c))
    graph[b].append((a, c))

d = [INF]*n
path = [[] for _ in range(n)]

dijkstra(0)
for i in range(1, n):
    for j in graph[i]:
        if j[0] == path[i][0]:
            path[i].append(j[1])
path[0] = [0, 0]

ans = [1]
for i in range(1, n):
    energy = arr[i]
    route = i
    while True:
        energy -= path[route][1]
        if energy < 0:
            ans.append(route+1)
            break
        elif route == 0:
            ans.append(route+1)
            break
        route = path[route][0]

print(*ans, sep='\n')
