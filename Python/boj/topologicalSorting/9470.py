import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

for _ in range(int(input())):
    k, m, p = map(int, input().split())
    graph = [[] for _ in range(m+1)]
    degree = [0]*(m+1)
    cnt = [[0, 0]]*(m+1)
    dp = [0]*(m+1)

    for _ in range(p):
        a, b = map(int, input().split())
        graph[a].append(b)
        degree[b] += 1
    
    q = deque()
    for i in range(1, m+1):
        if degree[i] == 0:
            q.append(i)
            cnt[i] = [1, 1]
    
    while q:
        cur = q.popleft()
        
        if cnt[cur][1] >= 2:
            dp[cur] = cnt[cur][0]+1
        else:
            dp[cur] = cnt[cur][0]

        for nxt in graph[cur]:
            degree[nxt] -= 1
            
            if cnt[nxt][0] == dp[cur]:
                cnt[nxt][1] += 1
            elif cnt[nxt][0] < dp[cur]:
                cnt[nxt] = [dp[cur], 1]
            
            if degree[nxt] == 0:
                q.append(nxt)
    
    print(k, dp[m])
