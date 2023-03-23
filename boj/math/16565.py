import sys
input = lambda: sys.stdin.readline().rstrip()

from math import factorial

MOD = 10007

def combinations(n, k):
    return factorial(n) // (factorial(k)*factorial(n-k))

n = int(input())
dp = [[0]*14 for _ in range(n+1)]

dp[0][0] = 1
for i in range(n):
    for j in range(13):
        for k in range(4):
            if i+k <= n:
                dp[i+k][j+1] += dp[i][j] * combinations(4, k)

idx, ans = 1, 0
while 4*idx <= n:
    tmp = combinations(13, idx)
    ans += tmp*dp[n-4*idx][13-idx]
    ans %= MOD
    idx += 1

print(ans%MOD)
