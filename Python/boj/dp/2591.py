import sys
input = lambda: sys.stdin.readline().rstrip()

s = input()
n = len(s)

dp = [[0]*2 for _ in range(n)]
dp[0][0], dp[0][1] = 1, 0
for i in range(1, n):
    if 10 <= int(s[i-1]+s[i]) <= 34:
        dp[i][1] = dp[i-1][0]
    if s[i] == "0":
        continue
    dp[i][0] = dp[i-1][0] + dp[i-1][1]

print(sum(dp[-1]))
