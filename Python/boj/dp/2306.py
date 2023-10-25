import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def dfs(x, y):
    if x > y:
        return 0
    if x == y:
        return 1
    if dp[x][y] != INF:
        return dp[x][y]
    
    if (s[x] == "a" and s[y] == "t") or (s[x] == "g" and s[y] == "c"):
        dp[x][y] = min(dp[x][y], dfs(x+1, y-1))
    
    for k in range(x, y):
        dp[x][y] = min(dp[x][y], dfs(x, k) + dfs(k+1, y))

    return dp[x][y]


s = input()
n = len(s)
dp = [[INF]*n for _ in range(n)]

print(n-dfs(0,n-1))
