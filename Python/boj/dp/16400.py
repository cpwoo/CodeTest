import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 123_456_789

n = int(input())

# n 이하 소수 구하기
v = [1]*(n+1)
v[0] = v[1] = 0

for i in range(2, n+1):
    if v[i]:
        for j in range(2*i, n+1, i):
            v[j] = 0

prime = [i for i in range(2, n+1) if v[i]]

dp = [0]*(n+1)
dp[0] = 1

for p in prime:
    for i in range(p, n+1):
        dp[i] = (dp[i]+dp[i-p])%MOD

print(dp[n])
