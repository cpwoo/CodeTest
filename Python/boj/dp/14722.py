import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]

if board[0][0] == 0:
    dp[0][0] = 1

for i in range(1, n):
    tmp = dp[i-1][0]
    if board[i][0] == tmp%3:
        dp[i][0] = tmp+1
    else:
        dp[i][0] = tmp

for j in range(1, n):
    tmp = dp[0][j-1]
    if board[0][j] == tmp%3:
        dp[0][j] = tmp+1
    else:
        dp[0][j] = tmp

for i in range(1, n):
    for j in range(1, n):
        tmp = max(dp[i-1][j], dp[i][j-1])
        if board[i][j] == tmp%3:
            dp[i][j] = tmp+1
        else:
            dp[i][j] = tmp

print(dp[-1][-1])
