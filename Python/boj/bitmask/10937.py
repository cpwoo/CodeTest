import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def dfs(cur, path):
    if cur >= n*n:
        return 0
    
    if dp[cur][path] != -1:
        return dp[cur][path]
    dp[cur][path] = 0

    dp[cur][path] = max(dp[cur][path], dfs(cur+1, path>>1))

    if path&1:
        dp[cur][path] = max(dp[cur][path], dfs(cur+1, path>>1))
    else:
        if cur+n < n*n and path&1 == 0:
            dp[cur][path] = max(dp[cur][path], 
                                dfs(cur+1, (path>>1)|(1<<(n-1))) + score[value[cur]+value[cur+n]])
        if cur%n != n-1 and path&2 == 0:
            dp[cur][path] = max(dp[cur][path],
                                dfs(cur+2, path>>2) + score[value[cur]+value[cur+1]])

    return dp[cur][path]


score = {"AA":100, "AB":70, "AC":40, "AF":0,
         "BA":70, "BB":50, "BC":30, "BF":0,
         "CA":40, "CB":30, "CC":20, "CF":0,
         "FA":0, "FB":0, "FC":0, "FF":0}

n = int(input())

value = "".join([input() for _ in range(n)])

dp = [[-1]*(1<<n) for _ in range(n*n)]

print(dfs(0,0))
