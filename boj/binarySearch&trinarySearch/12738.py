import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

n = int(input())
arr = list(map(int, input().split()))
dp = []

for a in arr:
    k = bisect_left(dp, a)
    if len(dp) <= k:
        dp.append(a)
    else:
        dp[k] = a

print(len(dp))
