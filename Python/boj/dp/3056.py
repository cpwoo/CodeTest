import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(cur, path):
    if cur == n:
        return 1
    
    if dp[path] != -1:
        return dp[path]
    
    for nxt in range(n):
        if not (path>>nxt)&1:
            dp[path] = max(dp[path], dfs(cur+1, path|(1<<nxt))*success[cur][nxt]/100)
    
    return dp[path]


n = int(input())
success = [list(map(int, input().split())) for _ in range(n)]
dp = [-1]*(1<<n)
print(dfs(0,0)*100)
