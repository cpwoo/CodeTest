import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

dp = [list(map(int, input().split())) for _ in range(n)]

for j in range(1, m):
    dp[0][j] += dp[0][j-1]

for i in range(1, n):
    left_to_right = dp[i][:]
    right_to_left = dp[i][:]

    for j in range(m):
        if j == 0:
            left_to_right[j] += dp[i-1][j]
        else:
            left_to_right[j] += max(dp[i-1][j], left_to_right[j-1])

    for j in range(m-1, -1, -1):
        if j == m-1:
            right_to_left[j] += dp[i-1][j]
        else:
            right_to_left[j] += max(dp[i-1][j], right_to_left[j+1])
    
    for j in range(m):
        dp[i][j] = max(left_to_right[j], right_to_left[j])

print(dp[-1][-1])
