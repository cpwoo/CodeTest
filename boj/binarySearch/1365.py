import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

n = int(input())
arr = list(map(int, input().split()))
dp = [arr[0]]
for i in range(1, n):
    idx = bisect_left(dp, arr[i])
    if idx == len(dp):
        dp.append(arr[i])
    else:
        dp[idx] = arr[i]

print(n-len(dp))
