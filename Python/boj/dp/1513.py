import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_007

n, m, c = map(int, input().split())

a = [[0]*(m+1) for _ in range(n+1)]
dp = [[[[0]*(c+1) for _ in range(c+1)] for _ in range(m+1)] for _ in range(n+1)]

dp[1][1][0][0] = 1
for i in range(1, c+1):
    x, y = map(int, input().split())
    if (x, y) == (1, 1):
        dp[1][1][0][0] = 0
        dp[1][1][i][1] = 1
    a[x][y] = i

for i in range(1, n+1):
    for j in range(1, m+1):
        if (i, j) == (1, 1): continue
        if a[i][j] > 0:
            for l in range(a[i][j]):
                for k in range(l+1):
                    dp[i][j][a[i][j]][k+1] += dp[i-1][j][l][k]+dp[i][j-1][l][k]
                    dp[i][j][a[i][j]][k+1] %= MOD
        else:
            for l in range(c+1):
                for k in range(l+1):
                    dp[i][j][l][k] = dp[i-1][j][l][k]+dp[i][j-1][l][k]
                    dp[i][j][l][k] %= MOD

ret = []
for i in range(c+1):
    tot = 0
    for j in range(c+1):
        tot += dp[n][m][j][i]
    ret.append(tot%MOD)

print(*ret)
