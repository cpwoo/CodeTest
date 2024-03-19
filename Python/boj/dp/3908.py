import sys
input = lambda: sys.stdin.readline().rstrip()

sieve = [True]*1121
sieve[0] = sieve[1] = False

for i in range(2, 1121):
    if sieve[i]:
        for j in range(i*i, 1121, i):
            sieve[j] = False

prime = [i for i in range(1121) if sieve[i]]

dp = [[0]*15 for _ in range(1121)]
dp[0][0] = 1

for p in prime:
    for i in range(1120, p-1, -1):
        for j in range(1, 15):
            dp[i][j] += dp[i-p][j-1]

for _ in range(int(input())):
    n, k = map(int, input().split())
    print(dp[n][k])
