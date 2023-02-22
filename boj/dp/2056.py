import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dp = [0]*(n+1)

for i in range(1, n+1):
    tmp = list(map(int, input().split()))
    for num in tmp[1:]:
        dp[i] = max(dp[i], dp[num]+tmp[0])

print(max(dp))
