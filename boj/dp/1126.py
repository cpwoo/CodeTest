import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dp = [0]*500001 # dp[i] : i 차이 날 때 둘 중 최댓값
rb = 1

for x in map(int, input().split()):
    rb += x
    nxt = dp[:]
    for i in range(rb):
        if dp[i]:
            neg = abs(i-x)
            nxt[i+x] = max(nxt[i+x], dp[i]+x)
            nxt[neg] = max(nxt[neg], dp[i], dp[i]-i+x)
    for i in range(rb):
        dp[i] = max(dp[i], nxt[i])
    dp[x] = max(dp[x], x)

print(dp[0] or -1)
