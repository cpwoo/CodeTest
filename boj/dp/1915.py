import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
arr = []
dp = [[0 for _ in range(m)] for _ in range(n)]
arr = [list(map(int, input())) for _ in range(n)]

ans = 0
for i in range(n):
    for j in range(m):
        if i == 0 or j == 0:
            dp[i][j] = arr[i][j]
        elif arr[i][j] == 0:
            dp[i][j] = 0
        else:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        
        ans = max(ans, dp[i][j])

print(ans*ans)
