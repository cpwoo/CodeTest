def solution(n, money):
    dp = [0]*(n+1)
    dp[0] = 1
    for m in money:
        for i in range(m, n+1):
            dp[i] += dp[i-m]
    return dp[n]


n = 5
money = [1,2,5]
print(solution(n, money)) # 4
