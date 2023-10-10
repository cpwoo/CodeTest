import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

n = int(input())
arr = list(map(int, input().split()))
ids = list(range(n))
dp = [arr[0]]

for i in range(1, n):
    if arr[i] > dp[-1]:
        dp.append(arr[i])
    tmp = bisect_left(dp, arr[i])
    dp[tmp] = arr[i]
    ids[i] = tmp

print(len(dp))

ans = []
tmp = len(dp)-1
for i in range(n-1, -1, -1):
    if ids[i] == tmp:
        ans.append(arr[i])
        tmp -= 1

print(*ans[::-1])
