import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
k = int(input())
dp = [[0 for _ in range(n+1)] for _ in range(3)]
s = [0]*(n+1)

for i in range(1, n+1):
    s[i] = s[i-1] + arr[i-1]

for i in range(3):
    for j in range((i+1)*k, n+1):
        if i == 0:
            dp[i][j] = max(dp[i][j-1], s[j] - s[j-k])
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j-k] + s[j] - s[j-k])

print(dp[-1][-1])
