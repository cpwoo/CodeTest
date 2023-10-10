import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]

for cnt in range(n-1):
    for i in range(n-1-cnt):
        j = i+cnt+1
        dp[i][j] = 1<<31
        for k in range(i, j):
            dp[i][j] = min(dp[i][j], dp[i][k]+dp[k+1][j]+matrix[i][0]*matrix[k][1]*matrix[j][1])

print(dp[0][-1])
