import sys
input = lambda: sys.stdin.readline().rstrip()

while True:
    n, m = input().split()
    
    if (n, m) == ("0", "0.00"):
        break

    n, m = int(n), int(float(m)*100)

    candies = []
    for _ in range(n):
        c, p = input().split()
        candies.append([int(c), int(float(p)*100+0.5)])

    dp = [0]*(m+1)
    for i in range(1, m+1):
        for j in range(n):
            c, p = candies[j]
            if p <= i:
                dp[i] = max(dp[i], dp[i-p]+c)

    print(dp[m])
