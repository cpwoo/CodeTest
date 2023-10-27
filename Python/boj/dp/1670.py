import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dp = [0]*10001
dp[0], dp[2], dp[4] = 1, 1, 2

i = 6
while i <= n:
    tmp = 0
    for j in range(0, i//2, 2):
        l, r = j, i-j-2
        if l != r:
            tmp += dp[l]*dp[r]*2
        else:
            tmp += dp[l]*dp[r]
    dp[i] = tmp%987654321
    i += 2

print(dp[n])
