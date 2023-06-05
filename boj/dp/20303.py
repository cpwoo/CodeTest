import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(x):
    group = [1, candy[x]]
    q = deque()
    q.append(x)
    visited[x] = 1
    
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = 1
                q.append(nxt)
                group[0] += 1
                group[1] += candy[nxt]
    
    return group


n, m, k = map(int, input().split())
candy = list(map(int, input().split()))
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)

visited = [0]*n

group = []
for i in range(n):
    if not visited[i]:
        group.append(bfs(i))
group = [[0, 0]] + group

N = len(group)
dp = [[0]*(k+1) for _ in range(N)]

for i in range(1, N):
    children, candy = group[i]
    for j in range(1, k+1):
        if j <= children:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j-children]+candy, dp[i-1][j])
    
print(dp[-1][k])
