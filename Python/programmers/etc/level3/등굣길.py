MOD = 1_000_000_007

def solution(m, n, puddles):
    dp = [[1]*m for _ in range(n)]
    
    for x, y in puddles:
        dp[y-1][x-1] = 0
    
    for i in range(m):
        if dp[0][i] == 0:
            for j in range(i+1, m):
                dp[0][j] = 0
            break
    
    for i in range(n):
        if dp[i][0] == 0:
            for j in range(i+1, n):
                dp[j][0] = 0
            break
    
    for i in range(1, n):
        for j in range(1, m):
            if dp[i][j] != 0:
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%MOD
    
    return dp[n-1][m-1]


m, n = 4, 3
puddles = [[2, 2]]
print(solution(m, n, puddles)) # 4
