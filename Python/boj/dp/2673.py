import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dp = [[0]*(101) for _ in range(101)]
cost = [[0]*(101) for _ in range(101)]

for _ in range(n):
    a, b = map(int, input().split())
    cost[a][b] = cost[b][a] = 1

for i in range(1, 101):
    for j in range(i, 0, -1):
        for k in range(j, i):
            dp[j][i] = max(dp[j][i], dp[j][k]+dp[k][i]+cost[i][j])

print(dp[1][100])
