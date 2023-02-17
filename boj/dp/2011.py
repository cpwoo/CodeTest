import sys
input = lambda: sys.stdin.readline().rstrip()

s = list(input())
n = len(s)
dp = [0]*(n+1)
dp[0], dp[1] = 1, 1

if s[0] == '0':
    print(0)
else:
    for i in range(2, n+1):
        if int(s[i-1]) > 0:
            dp[i] += dp[i-1]
        if 10 <= int(s[i-2]+s[i-1]) <= 26:
            dp[i] += dp[i-2]
    print(dp[n]%1_000_000)
