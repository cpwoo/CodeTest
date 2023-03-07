import sys
input = lambda: sys.stdin.readline().rstrip()

MAX = 1010
MOD = 10007

st = input()
n = len(st)

dp = [[0]*MAX for _ in range(MAX)]

for i in range(n):
    dp[i][i] = 1

for i in range(n-1):
    dp[i][i+1] = 3 if st[i] == st[i+1] else 2

for L in range(2, n):
    for left in range(n):
        right = left+L
        if right > n-1: break
        
        dp[left][right] = dp[left+1][right]+dp[left][right-1]-dp[left+1][right-1]+MOD

        if st[left] == st[right]:
            dp[left][right] += dp[left+1][right-1]+1
        
        dp[left][right] %= MOD

print(dp[0][n-1])
