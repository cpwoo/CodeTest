import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
jewel = [int(input()) for _ in range(n)]

_sum = [0]*(n+1)
for i in range(1, n+1):
    _sum[i] = _sum[i-1]+jewel[i-1]

dp = [0]*(n+1)

chk = 0
for i in range(1, n+1):
    if i >= m:
        chk = min(chk, _sum[i-m])
        dp[i] = max(dp[i-1], _sum[i]-chk)
    else:
        dp[i] = dp[i-1]

print(dp[-1])
