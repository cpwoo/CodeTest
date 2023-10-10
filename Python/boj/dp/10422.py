import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007
dp = [0]*5001
dp[0] = 1
for i in range(2, 5001, 2):
    for j in range(2, i+1, 2):
        dp[i] += (dp[j-2]*dp[i-j]) % MOD

for _ in range(int(input())):
    print(dp[int(input())] % MOD)
