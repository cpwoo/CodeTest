import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
_max = 100 * 1000 + 1
dp = [[[_max]*3 for _ in range(m)] for _ in range(n)]

for y in range(n):
    if y == 0:
        for x in range(m):
            for d in range(3):
                dp[y][x][d] = board[y][x]
    else:
        for x in range(m):
            if x == 0:
                dp[y][x][0] = min(dp[y-1][x+1][1], dp[y-1][x+1][2]) + board[y][x]
                dp[y][x][1] = dp[y-1][x][0] + board[y][x]
            elif x == m-1:
                dp[y][x][1] = dp[y-1][x][2] + board[y][x]
                dp[y][x][2] = min(dp[y-1][x-1][0], dp[y-1][x-1][1]) + board[y][x]
            else:
                dp[y][x][0] = min(dp[y-1][x+1][1], dp[y-1][x+1][2]) + board[y][x]
                dp[y][x][1] = min(dp[y-1][x][0], dp[y-1][x][2]) + board[y][x]
                dp[y][x][2] = min(dp[y-1][x-1][0], dp[y-1][x-1][1]) + board[y][x]

ans = int(1e9)
for x in range(m):
    ans = min(min(dp[n-1][x]), ans)

print(ans)
