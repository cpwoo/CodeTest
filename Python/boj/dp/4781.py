import sys
input = lambda: sys.stdin.readline().rstrip()


while True:
    n, m = input().split()
    
    if (n, m) == ("0", "0.00"):
        break

    n, m = int(n), int(float(m)*100)

    tmp = []
    for _ in range(n):
        c, p = input().split()
        tmp.append([int(c), int(float(p)*100+0.5)])
    tmp.sort()

    candies = [tmp[0]]

    for i in range(1, n):
        if tmp[i][0] > candies[-1][0]:
            candies.append(tmp[i])
    
    dp = [0]*(m+1)
    for c, p in candies:
        for i in range(p, m+1):
            cnt = dp[i-p]+c
            if cnt > dp[i]:
                dp[i] = cnt

    print(dp[m])
