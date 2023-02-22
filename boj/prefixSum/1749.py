import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*(m+1) for _ in range(n+1)]
res = -int(1e9)

for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = board[i-1][j-1]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]
        
        for y in range(i):
            for x in range(j):
                res = max(dp[i][j]-dp[y][j]-dp[i][x]+dp[y][x], res)
                
print(res)
