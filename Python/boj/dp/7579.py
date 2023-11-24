import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
memories = list(map(int, input().split()))
cost = list(map(int, input().split()))

tc = sum(cost)
result = sys.maxsize

dp = [[0 for _ in range(tc)] for _ in range(N)]

for i in range(N):
    for j in range(tc):
        if cost[i] > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], memories[i] + dp[i-1][j-cost[i]])
        
        if dp[i][j] >= M:
            result = min(result, j)

if M == 0 or tc == 0:
    print(0)
elif N == 1:
    print(cost[0])
elif result == sys.maxsize:
    print(N*M)
else:
    print(result)
