import sys
input = lambda: sys.stdin.readline().rstrip()

dp = [0]*30
dp[0], dp[1], dp[2], dp[3] = 1, 5, 11, 36

for i in range(4, 30):
    dp[i] = dp[i-1] + dp[i-2]*5 + dp[i-3] - dp[i-4]

for _ in range(int(input())):
    print(dp[int(input())-1])
