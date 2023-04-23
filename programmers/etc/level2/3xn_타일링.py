MOD = 1_000_000_007

def solution(n):
    answer = 0
    dp = [0]*(n+1)
    dp[2] = 3
    dp[4] = 11
    for i in range(6, n+1, 2):
        dp[i] = (4*dp[i-2]-dp[i-4])%MOD
    return dp[n]


n = 4
print(solution(n)) # 11
