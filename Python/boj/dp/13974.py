import sys
input = lambda: sys.stdin.readline().rstrip()

# 사각부등식과 단조성 모두 만족 => Knuth 최적화 사용
# dp[i][j] = min(dp[i][k]+dp[k][j]) + C[i][j] (i < j < k)
# 사각부등식: C[a][c] + C[b][d] <= C[a][d] + C[b][c] (a <= b <= c <= d)
# 단조성: C[b][c] <= C[a][d] (a <= b <= c <= d)
# 단, C(비용)은 k에 독립적

# 위 조건을 만족하면 P[i][j] = dp[i][j]가 최소가 되기 위한 가장 작은 k일 때 P[i][j-1] <= P[i][j] <= P[i+1][j]

INF = sys.maxsize

def solve(n):
    s = [0]*(n+1)
    for i in range(1, n+1):
        s[i] = s[i-1] + v[i-1]
    
    dp = [[0]*(n+1) for _ in range(n+1)]
    K = [[0]*(n+1) for _ in range(n+1)]
    for i in range(1, n+1):
        dp[i-1][i] = 0
        K[i-1][i] = i

    for m in range(2, n+1):
        for i in range(n-m+1):
            j = i+m
            dp[i][j] = INF
            for k in range(K[i][j-1], K[i+1][j]+1):
                now = dp[i][k]+dp[k][j]+s[j]-s[i]
                if now < dp[i][j]:
                    dp[i][j] = now
                    K[i][j] = k

    return dp[0][n]


for _ in range(int(input())):
    n = int(input())
    v = list(map(int, input().split()))
    print(solve(n))
