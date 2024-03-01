import sys
input = lambda : sys.stdin.readline().rstrip()

for _ in range(3):
    dp = [0]*50001
    dp[0] = 1

    n = int(input())
    coins = sorted([list(map(int, input().split())) for _ in range(n)])
    
    tot = sum([coin[0]*coin[1] for coin in coins])
    
    if tot%2 == 1:
        print(0)
        continue

    half = tot//2

    for coin in coins:
        for i in range(tot//2, coin[0]-1, -1):
            if dp[i-coin[0]]:
                for j in range(coin[1]):
                    if i+j*coin[0] > half: break
                    dp[i+j*coin[0]] = 1
    
    print(dp[half])
