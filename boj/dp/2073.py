import sys
input = lambda: sys.stdin.readline().rstrip()

D, P = map(int, input().split())
dp = [0]*(D+1)
dp[0] = int(1e9)

for _ in range(P):
    L, C = map(int, input().split())
    tmp = dp[:]
    for i in range(L, D+1):
        if tmp[i-L]:
            dp[i] = max(dp[i], min(tmp[i-L], C))

print(dp[D])
