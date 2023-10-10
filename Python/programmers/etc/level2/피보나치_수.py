MOD = 1234567

def solution(n):
    dp = [0]*(n+1)
    dp[1] = 1
    for i in range(2, n+1):
        dp[i] = (dp[i-1]+dp[i-2])%MOD
    return dp[n]


n = 3
print(solution(n)) # 2

n = 5
print(solution(n)) # 5
