import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

n = int(input())
a = list(map(int, input()))
b = list(map(int, input()))

dp = [[INF]*10 for _ in range(n+1)]

for i in range(10):
    dp[0][i] = i

for i in range(1, n+1):
    for j in range(10):
        lcnt = (b[i-1]-a[i-1]-j+20)%10
        rcnt = 10-lcnt
        dp[i][j] = min(dp[i][j], dp[i-1][j]+rcnt)
        dp[i][(j+lcnt)%10] = min(dp[i][(j+lcnt)%10], dp[i-1][j]+lcnt)

print(min(dp[n]))
