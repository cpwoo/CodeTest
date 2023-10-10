import sys
input = lambda: sys.stdin.readline().rstrip()

N, M, K = map(int, input().split())
path = [[0]*(N+1) for _ in range(N+1)]
for _ in range(K):
    a, b, c = map(int, input().split())
    path[a][b] = max(path[a][b], c)

dp = [[0]*(M+1) for _ in range(N+1)]

for i in range(2, N+1):
    dp[i][2] = path[1][i]

for i in range(2, N+1):
    for j in range(3, M+1):
        for p in range(1, i):
            if path[p][i] and dp[p][j-1]:
                dp[i][j] = max(dp[p][j-1]+path[p][i], dp[i][j])

print(max(dp[N]))
