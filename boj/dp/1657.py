import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(100000)

INF = sys.maxsize

def dfs(cur, path):
    # 범위 초과시 0 return
    if cur >= n*m:
        return 0
    
    # memoization
    if dp[cur][path] != -1:
        return dp[cur][path]
    dp[cur][path] = 0

    # 채워진 여부에 상관없이 지나치는 경우 계산
    dp[cur][path] = max(dp[cur][path], dfs(cur+1, path>>1))

    # 채워진 경우 지나친다
    if path&1:
        dp[cur][path] = max(dp[cur][path], dfs(cur+1, path>>1))
    # 아니면
    else:
        # 밑칸을 채우거나
        if cur+m < n*m and path&1 == 0:
            dp[cur][path] = max(dp[cur][path], 
                                dfs(cur+1, (path>>1)|(1<<(m-1))) + score[value[cur]+value[cur+m]])
        # 옆칸을 채운다
        if cur%m != m-1 and path&2 == 0:
            dp[cur][path] = max(dp[cur][path],
                                dfs(cur+2, path>>2) + score[value[cur]+value[cur+1]])
        
    return dp[cur][path]


score = {"AA":10, "AB":8, "AC":7, "AD":5, "AF":1,
         "BA":8, "BB":6, "BC":4, "BD":3, "BF":1,
         "CA":7, "CB":4, "CC":3, "CD":2, "CF":1,
         "DA":5, "DB":3, "DC":2, "DD":2, "DF":1,
         "FA":1, "FB":1, "FC":1, "FD":1, "FF":0}

n, m = map(int, input().split())

value = "".join([input() for _ in range(n)])

dp = [[-1]*(1<<m) for _ in range(n*m)]

print(dfs(0,0))
