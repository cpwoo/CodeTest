import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1000

a, b, d, N = map(int, input().split())
dp = [0]*(N+1)
dp[0] = 1

for i in range(1, N+1):
    if i < a:
        dp[i] = dp[i-1]
    elif i < b:
        dp[i] = (dp[i-1]+dp[i-a])%MOD
    else:
        dp[i] = (dp[i-1]+dp[i-a]-dp[i-b]+MOD)%MOD

print(dp[N]%MOD if d > N else (dp[N]-dp[N-d]+MOD)%MOD)
