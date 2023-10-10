import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(start):
    q = []
    heappush(q, [0, start])
    dp = [int(1e9)] * (n+1)
    dp[start] = 0
    while q:
        d, now = heappop(q)
        if dp[now] < d:
            continue
        for i in graph[now]:
            cost = d + i[1]
            if cost < dp[i[0]]:
                dp[i[0]] = cost
                heappush(q, [cost, i[0]])    
    return dp

for _ in range(int(input())):
    n, m, t = map(int, input().split())
    s, g, h = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b, d = map(int, input().split())
        graph[a].append([b, d])
        graph[b].append([a, d])

    lst = [int(input()) for _ in range(t)]

    first = dijkstra(s)

    g_dijk = dijkstra(g)
    h_dijk = dijkstra(h)

    answer = []

    for i in lst:
        if (first[g] + g_dijk[h] + h_dijk[i] == first[i]) or (first[h] + h_dijk[g] + g_dijk[i] == first[i]):
            answer.append(i)

    answer.sort()
    print(*answer)
