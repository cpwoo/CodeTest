import sys
input = lambda : sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for i in range(1, M+1):
    u, v = map(int, input().split())
    graph[u].append((v, i))
    graph[v].append((u, i))

time = [INF]*(N+1)
time[1] = 0

q = []
heappush(q, (0, 1))

while q:
    cur_cost, cur_node = heappop(q)
    if time[cur_node] < cur_cost:
        continue

    for nxt_node, nxt_cost in graph[cur_node]:
        cost = (cur_cost//M)*M + nxt_cost
        
        if cost < cur_cost:
            cost += M
        
        if time[nxt_node] > cost:
            time[nxt_node] = cost
            heappush(q, (cost, nxt_node))


print(time[N])
