import sys
input = lambda: sys.stdin.readline().rstrip()

m, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(m)]

dp = [[0]*(n+1) for _ in range(m+1)]

_max = 0
for i in range(1, m+1):
    for j in range(1, n+1):
        if arr[i-1][j-1] == 0:
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
            _max = max(_max, dp[i][j])

print(_max)
