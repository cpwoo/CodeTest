import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[0]*n for _ in range(n)]

for i in range(1, n):
    dp[i][0] = dp[i-1][0] + max(arr[i][0]-arr[i-1][0]+1, 0)
    dp[0][i] = dp[0][i-1] + max(arr[0][i]-arr[0][i-1]+1, 0)

for i in range(1, n):
    for j in range(1, n):
        dp[i][j] = min(dp[i-1][j]+max(arr[i][j]-arr[i-1][j]+1, 0), dp[i][j-1]+max(arr[i][j]-arr[i][j-1]+1, 0))

print(dp[-1][-1])
