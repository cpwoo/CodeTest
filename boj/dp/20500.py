import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

dp = [0]*1516

for i in range(2, 1516):
    if i&1:
        dp[i] = (dp[i-1]*2-1)%MOD
    else:
        dp[i] = (dp[i-1]*2+1)%MOD

print(dp[int(input())])
