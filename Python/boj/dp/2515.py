import sys
input = lambda: sys.stdin.readline().rstrip()

n, s = map(int, input().split())
arr = sorted([list(map(int, input().split())) for _ in range(n)])

dp = [0]*n
dp[0] = arr[0][1]

idx, val = 0, 0
for i in range(1, n):
    while (arr[idx][0] <= arr[i][0]-s):
        val = max(val, dp[idx])
        idx += 1
    dp[i] = val+arr[i][1]

print(max(dp))
