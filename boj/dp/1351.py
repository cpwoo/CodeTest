import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

def dfs(x):
    if dp[x] != 0:
        return dp[x]
    
    dp[x] = dfs(x//P) + dfs(x//Q)
    return dp[x]

N, P, Q = map(int, input().split())
dp = defaultdict(int)
dp[0] = 1

print(dfs(N))
