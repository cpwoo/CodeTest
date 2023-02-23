import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [int(input()) for _ in range(n)]
dp = [0]*n

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1

print(n-max(dp))
