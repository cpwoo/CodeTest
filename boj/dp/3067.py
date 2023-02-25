import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n = int(input())
    coins = list(map(int, input().split()))
    cost = int(input())
    dp = [0] * (cost+1)
    dp[0] = 1
    for coin in coins:
        for i in range(1, cost+1):
            if i-coin >= 0:
                dp[i] += dp[i-coin]
    print(dp[cost])
