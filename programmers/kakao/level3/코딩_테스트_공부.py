import sys
INF = sys.maxsize

def solution(alp, cop, problems):
    max_alp, max_cop = 0, 0
    for a, b, c, d, e in problems:
        max_alp = max(max_alp, a)
        max_cop = max(max_cop, b)
    alp = min(alp, max_alp)
    cop = min(cop, max_cop)
    dp = [[INF]*(max_cop+1) for _ in range(max_alp+1)]
    dp[alp][cop] = 0
    for i in range(alp, max_alp+1):
        for j in range(cop, max_cop+1):
            if i+1 <= max_alp:
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+1)
            if j+1 <= max_cop:
                dp[i][j+1] = min(dp[i][j+1], dp[i][j]+1)

            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i >= alp_req and j >= cop_req:
                    next_alp, next_cop = min(max_alp,i+alp_rwd), min(max_cop,j+cop_rwd)
                    dp[next_alp][next_cop] = min(dp[next_alp][next_cop], dp[i][j]+cost)
    return dp[max_alp][max_cop]


alp, cop = 10, 10
problems = [[10,15,2,1,2],[20,20,3,3,4]]
print(solution(alp, cop, problems)) # 15

alp, cop = 0, 0
problems = [[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]	
print(solution(alp, cop, problems)) # 13
