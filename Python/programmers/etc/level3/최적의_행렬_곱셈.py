import sys
INF = sys.maxsize

def solution(m):
    n = len(m)
    dp = [[INF]*n for _ in range(n)]
    for i in range(n):
        dp[i][i] = 0
    
    for gap in range(1, n):
        for start in range(n):
            end = start+gap
            if end >= n: break
            for sep in range(start, end):
                value = dp[start][sep]+dp[sep+1][end]+(m[start][0]*m[sep][1]*m[end][1])
                dp[start][end] = min(dp[start][end], value)
    
    return dp[0][-1]


m = [[5,3],[3,10],[10,6]]
print(solution(m)) # 270
