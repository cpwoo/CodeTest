import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

dp = [[0]*(m+1) for _ in range(n+1)]
block = set()

for _ in range(int(input())):
    a, b, c, d = map(int, input().split())
    
    if a > c: a, c = c, a
    if b > d: b, d = d, b

    block.add((a,b,c,d))

if (0, 0, 1, 0) not in block: dp[1][0] = 1
if (0, 0, 0, 1) not in block: dp[0][1] = 1

for i in range(2, n+1):
    if (i-1, 0, i, 0) not in block and dp[i-1][0]:
        dp[i][0] = 1

for i in range(2, m+1):
    if (0, i-1, 0, i) not in block and dp[0][i-1]:
        dp[0][i] = 1

for i in range(1, n+1):
    for j in range(1, m+1):
        if (i-1, j, i, j) not in block:
            dp[i][j] += dp[i-1][j]
        if (i, j-1, i, j) not in block:
            dp[i][j] += dp[i][j-1]
    
print(dp[n][m])
