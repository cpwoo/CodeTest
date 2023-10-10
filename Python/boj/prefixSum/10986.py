import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
nums = list(map(int, input().split())) + [0]
dp = [0]*m
for i in range(n):
    nums[i] += nums[i-1]
    dp[nums[i] % m] += 1

cnt = dp[0]

for i in dp:
    cnt += i*(i-1)//2
    
print(cnt)
