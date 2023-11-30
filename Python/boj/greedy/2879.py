import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

diff = [B[i]-A[i] for i in range(N)]

dp = [0]*N
dp[0] = abs(diff[0])

for i in range(1, N):
    if diff[i]*diff[i-1] > 0:
        dp[i] = dp[i-1] + max(0, abs(diff[i])-abs(diff[i-1]))
    else:
        dp[i] = dp[i-1] + abs(diff[i])

print(dp[-1])
