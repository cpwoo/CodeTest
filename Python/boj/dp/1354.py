import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(n):
    if n <= 0: return 1
    if n in dp: return dp[n]
    dp[n] = dfs(n//p-x) + dfs(n//q-y)
    return dp[n]


n, p, q, x, y = map(int, input().split())
dp = {}
print(dfs(n))
