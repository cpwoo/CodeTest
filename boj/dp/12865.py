import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
items = [list(map(int, input().split())) for _ in range(n)]

dp = [[0]*(k+1) for _ in range(n+1)]
    
for i in range(1,n+1):
    weight, value = items[i-1]
    for j in range(1,k+1):
        if weight <= j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
        else:
            dp[i][j] = dp[i-1][j]

print(dp[n][k])
