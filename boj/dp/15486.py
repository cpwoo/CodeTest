import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
t, p = [], []

dp = [0] * (n+1)

for _ in range(n):
    x, y = map(int, input().split())
    t.append(x)
    p.append(y)

for i in range(n):
    if i+t[i] <= n:
        dp[i+t[i]] = max(dp[i+t[i]], dp[i]+p[i])
    dp[i+1] = max(dp[i+1], dp[i])

print(dp[n])
