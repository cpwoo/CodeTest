MOD = 1_000_000_007

def solution(n):
    dp = [0]*(n+1)
    dp[1] = 1
    dp[2] = 2
    for i in range(3, n+1):
        dp[i] = (dp[i-1]+dp[i-2])%MOD
    return dp[n]


n = 4
print(solution(n)) # 5
