import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_000

n = int(input())
dp = [0]*(n+1)
dp[0], dp[1] = 1, 0
for i in range(2, n+1):
    dp[i] = ((i-1)*(dp[i-1]+dp[i-2]))%MOD

print(dp[n])
