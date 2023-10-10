import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007
n = int(input())

dp = [0 for _ in range(n+2)]
dp[0], dp[1], dp[2] = 1, 2, 7

if n <= 2:
    print(dp[n])
    exit()

for i in range(3, n+1):
    dp[i]=(dp[i-1]*3+dp[i-2]-dp[i-3]) % MOD

print(dp[n] % MOD)
