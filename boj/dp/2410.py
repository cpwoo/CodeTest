import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_000

n = int(input())
dp = [0]*(n+1)
dp[0] = 1
nums = [2**x for x in range(21)]
for num in nums:
    if num <= n:
        for i in range(num, n+1):
            dp[i] += dp[i-num]%MOD

print(dp[n]%MOD)
