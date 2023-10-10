import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

n, m = map(int, input().split())
fail = list(map(int, input().split()))

graph = [[] for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

d = [INF]*n
d[0] = 0
q = []
heappush(q, (0, 0))
while q:
    cur_cost, cur_node = heappop(q)
    
    if d[cur_node] < cur_cost: continue

    for nxt_node, nxt_cost in graph[cur_node]:
        cost = cur_cost + nxt_cost

        if d[nxt_node] > cost and (nxt_node == n-1 or not fail[nxt_node]):
            d[nxt_node] = cost
            heappush(q, (cost, nxt_node))

ans = d[-1]

print(ans if ans != INF else -1)
