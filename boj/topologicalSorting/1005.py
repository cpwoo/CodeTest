import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

for _ in range(int(input())):
    n, k = map(int, input().split())
    d = [0] + list(map(int, input().split()))
    graph = [[] for _ in range(n+1)]
    degree = [0]*(n+1)
    dp = [0]*(n+1)
    
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x].append(y)
        degree[y] += 1
    
    q = deque()
    for i in range(1, n+1):
        if degree[i] == 0:
            q.append(i)
            dp[i] = d[i]
            
    while q:
        p = q.popleft()
        for i in graph[p]:
            degree[i] -= 1
            dp[i] = max(dp[p]+d[i], dp[i])
            if degree[i] == 0:
                q.append(i)

    print(dp[int(input())])
