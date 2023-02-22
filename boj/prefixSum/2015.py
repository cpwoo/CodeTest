import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

n, k = map(int, input().split())
nums = list(map(int, input().split()))
cnt = 0
prefix = defaultdict(int)

for i in range(1, n):
    nums[i] += nums[i-1]
    
for i in range(n):
    if nums[i] == k:
        cnt += 1
    cnt += prefix[nums[i]-k]
    prefix[nums[i]] += 1
    
print(cnt)
