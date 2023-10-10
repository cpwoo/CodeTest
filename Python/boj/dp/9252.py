import sys
input = lambda: sys.stdin.readline().rstrip()

s1 = [0] + list(input())
s2 = [0] + list(input())

n = len(s1)
m = len(s2)

dp = [[""]*m for _ in range(n)]
for i in range(1, n):
    for j in range(1, m):
        if s1[i] == s2[j]:
            dp[i][j] = dp[i-1][j-1] + s1[i]
        else:
            if len(dp[i-1][j]) > len(dp[i][j-1]):
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i][j-1]

print(len(dp[n-1][m-1]))
print(dp[n-1][m-1])
