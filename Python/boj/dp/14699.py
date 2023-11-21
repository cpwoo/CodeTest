import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(100000)

def solve(idx):
    if dp[idx] != 0:
        return dp[idx]
    dp[idx] = 1
    for nxt in graph[idx]:
        dp[idx] = max(dp[idx], solve(nxt)+1)
    return dp[idx]

n, m = map(int, input().split())
height = [0] + list(map(int, input().split()))

graph = [set() for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    if height[a] > height[b]:
        a, b = b, a
    graph[a].add(b)

dp = [0]*(n+1)

for i in range(1, n+1):
    solve(i)

print(*dp[1:], sep='\n')
