import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(start):
    q = []
    heappush(q, [0, start])
    dp = [int(1e9)]*(N+1)
    dp[start] = 0
    while q:
        cur_cost, cur_node = heappop(q)
        for nxt_node, nxt_cost in d[cur_node]:
            cost = cur_cost + nxt_cost
            if dp[nxt_node] > cost:
                dp[nxt_node] = cost
                heappush(q, [cost, nxt_node])
    return dp

for _ in range(int(input())):
    N, D, C = map(int, input().split())
    d = [[] for _ in range(N+1)]
    for _ in range(D):
        a, b, s = map(int, input().split())
        d[b].append([a, s])

    dp = dijkstra(C)

    cnt = 0
    ans = 0
    for i in dp:
        if i != int(1e9):
            if ans < i:
                ans = i
            cnt += 1
    print(cnt, ans)
