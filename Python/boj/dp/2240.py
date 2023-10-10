import sys
input = lambda: sys.stdin.readline().rstrip()

T, W = map(int, input().split())
arr = [0] + [int(input()) for _ in range(T)]

dp = [[0]*(W+1) for _ in range(T+1)]

for i in range(1, T+1):
    if arr[i] == 1:
        dp[i][0] = dp[i-1][0] + 1
    else:
        dp[i][0] = dp[i-1][0]

    for j in range(1, W+1):
        if j > i:
            break

        if arr[i] == 1 and j%2 == 0:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + 1

        elif arr[i] == 2 and j%2 == 1:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + 1
        
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1])

print(max(dp[-1]))
