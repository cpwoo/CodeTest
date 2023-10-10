import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def dijkstra(start):
    dp = [int(1e9)] * (N+1)
    dp[start] = 0
    q = []
    heappush(q, [0, start])
    
    while q:
        dist, now = heappop(q)        
        if dist > dp[now]:
            continue
        for nxt, cost in graph[now]:
            cost += dist
            if dp[nxt] > cost:
                dp[nxt] = cost
                heappush(q, [cost, nxt])
    return dp


N = int(input())
A, B, C = map(int, input().split())
M = int(input())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    D, E, L = map(int, input().split())
    graph[D].append([E, L])
    graph[E].append([D, L])

a, b, c = dijkstra(A), dijkstra(B), dijkstra(C)
v = 0
answer = 0
for i in range(1, N+1):
    now = min(a[i], min(b[i], c[i]))
    if v < now:
        v = now
        answer = i

print(answer)
