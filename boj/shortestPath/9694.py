import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

for i in range(int(input())):
    n, m = map(int, input().split())
    graph = [[] for _ in range(m)]
    for _ in range(n):
        a, b, c = map(int, input().split())
        graph[a].append([b, c])
        graph[b].append([a, c])
    
    dp = [[] for _ in range(m)]
    q = []
    heappush(q, (0, 0, 0))
    visited = [False]*m
    while q:
        cost, cur, prev = heappop(q)
        if visited[cur]:
            continue
        else:
            dp[cur] = dp[prev]+[cur]
        if cur == m-1:
            break
        visited[cur] = True
        for nxt_node, nxt_cost in graph[cur]:
            heappush(q, (nxt_cost+cost, nxt_node, cur)) 

    print(f"Case #{i+1}:", end=" ")
    if dp[m-1]:
        print(*dp[m-1])
    else:
        print(-1)
