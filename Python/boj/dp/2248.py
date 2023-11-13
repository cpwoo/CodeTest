import sys
input = lambda: sys.stdin.readline().rstrip()

N, L, I = map(int, input().split())
dp = [[0]*(L+1) for _ in range(N)]

for i in range(L+1):
    dp[0][i] = 1

for i in range(1, N):
    dp[i][0] = dp[i-1][0]
    for j in range(1, L+1):
        dp[i][j] = dp[i-1][j]+dp[i-1][j-1]

answer = []

for i in range(N-1, -1, -1):
    if I <= dp[i][L]:
        answer.append("0")
    else:
        answer.append("1")
        I -= dp[i][L]
        L -= 1

print("".join(answer))
