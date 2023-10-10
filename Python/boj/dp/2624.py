import sys
input = lambda: sys.stdin.readline().rstrip()

t = int(input())
k = int(input())
coins = [[0, 0]]
dp = [[0 for _ in range(t+1)] for _ in range(k+1)]
dp[0][0] = 1

for _ in range(k):
    p, n = map(int, input().split())
    coins.append([p, n])
    
for i in range(1, k+1):
    coin, cnt = coins[i]
    for j in range(t+1):
        dp[i][j] = dp[i-1][j]
        for v in range(1, cnt+1):
            if j - v*coin >= 0:
                dp[i][j] += dp[i-1][j - v*coin]
            else:
                break

print(dp[k][t])
