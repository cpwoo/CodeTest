import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

def dijkstra(pos):
    cost = [INF]*(n+1)
    cost[pos] = 0

    q = []
    heappush(q, (0, pos))
    
    while q:
        cur_cost, cur_node = heappop(q)
        if cost[cur_node] != cur_cost: continue
        
        for nxt_node, nxt_cost in graph[cur_node]:
            if cost[nxt_node] > cur_cost+nxt_cost:
                cost[nxt_node] = cur_cost+nxt_cost
                heappush(q, (cost[nxt_node], nxt_node))
    
    return cost


for _ in range(int(input())):
    n, m = map(int, input().split())
    answer = [INF]*(n+1)
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))
        graph[b].append((a, c))
    
    k = int(input())
    friends = list(map(int, input().split()))
    for i in range(1, n+1):
        dist = dijkstra(i)
        answer[i] = sum(dist[f] for f in friends)
    
    print(answer.index(min(answer)))
