import sys
input = lambda: sys.stdin.readline().rstrip()

dp = [[[0]*2 for _ in range(100)] for _ in range(101)]
dp[1][0][0], dp[1][0][1] = 1, 1

for i in range(2, 101):
    for j in range(i):
        dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1]
        dp[i][j][1] = dp[i-1][j][0] + dp[i-1][j-1][1]
    
for _ in range(int(input())):
    n, k = map(int, input().split())
    print(sum(dp[n][k]))
