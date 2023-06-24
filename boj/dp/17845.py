import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(k)]
dp = [[0]*(n+1) for _ in range(k+1)]

for i in range(1, k+1):
    cost, time = arr[i-1]
    for j in range(1, n+1):
        if time <= j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-time]+cost)
        else:
            dp[i][j] = dp[i-1][j]

print(dp[k][n])
