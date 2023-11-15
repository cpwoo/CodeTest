import sys
input = lambda: sys.stdin.readline().rstrip()

k = 0
coin = [1, 10, 25]

for _ in range(int(input())):
    x = int(input())
    ret = 0
    dp = [int(1e15)+1]*100
    dp[0] = 0
    
    for c in coin:
        for i in range(c, 100):
            dp[i] = min(dp[i], dp[i-c]+1)
    
    while x:
        ret += dp[x%100]
        x //= 100
    
    print(ret)
