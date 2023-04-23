MOD = 1234567

def solution(n):
    dp = [0]*2001
    dp[1], dp[2] = 1, 2
    for i in range(3, n+1):
        dp[i] = (dp[i-1]+dp[i-2])%MOD
    return dp[n]


n = 4
print(solution(n)) # 5

n = 3
print(solution(n)) # 3
