import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = sys.maxsize

for _ in range(int(input())):
    n, m, k = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    for _ in range(k):
        u, v, c, d = map(int, input().split())
        graph[u].append((v, c, d))

    dp = [[INF]*(m+1) for _ in range(n+1)]
    dp[1][0] = 0

    for c in range(m+1):
        for d in range(1, n+1):
            if dp[d][c] == INF:
                continue
            t = dp[d][c]
            for nv, nc, nd in graph[d]:
                if nc+c > m:
                    continue
                dp[nv][nc+c] = min(dp[nv][nc+c], t+nd)
    
    res = min(dp[n])
    print(res if res != INF else "Poor KCM")
