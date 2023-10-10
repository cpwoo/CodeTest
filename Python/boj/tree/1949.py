import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**5)

def dfs(cur):
    visited[cur] = 1
    for nxt in graph[cur]:
        if not visited[nxt]:
            dfs(nxt)
            dp[cur][1] += dp[nxt][0]
            dp[cur][0] += max(dp[nxt][0], dp[nxt][1])


n = int(input())
score = [0] + list(map(int, input().split()))

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0]*(n+1)
dp = [[0, score[i]]*2 for i in range(n+1)]

dfs(1)
print(max(dp[1][1], dp[1][0]))
