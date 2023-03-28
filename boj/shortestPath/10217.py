import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = int(1e9)
for _ in range(int(input())):
    n, cost, m = map(int, input().split())
    dp = [[INF]*n for _ in range(cost+1)]
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        u, v, c, d = map(int, input().split())
        graph[u-1].append((v-1, c, d))
     
    q = [(0, 0, 0)]
    while q:
        curDist, curCost, curNode = heappop(q)
        if curDist > dp[curCost][curNode]:
            continue

        for toNode, toCost, toDist in graph[curNode]:
            d = curDist + toDist
            c = curCost + toCost
            if c <= cost and d < dp[c][toNode]:
                for i in range(c, cost+1):
                    if dp[i][toNode] > d:
                        dp[i][toNode] = d
                    else:
                        break
                heappush(q, (d, c, toNode))
    print(dp[cost][n-1] if dp[cost][n-1] != INF else "Poor KCM")
