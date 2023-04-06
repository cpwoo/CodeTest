MOD = int(1e7)+19

def solution(a):
    # 행과 열 개수 구하기
    row, col = len(a), len(a[0])
    # 각 열마다 1 개수 check
    num = [0]*(col+1)
    for i in range(row):
        for j in range(col):
            if a[i][j] == 1:
                num[j] += 1
    # nCr 구하기 
    comb = [[0]*(row+1) for _ in range(row+1)]
    comb[0][0] = 1
    for i in range(1, row+1):
        for j in range(0, i+1):
            if j == 0 or i == j:
                comb[i][j] = 1
            else:
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % MOD
    
    dp = [[0]*(row+1) for _ in range(col+2)]
    dp[1][row-num[0]] = comb[row][row-num[0]]
    
    for c in range(1, col+1):
        for r in range(0, row+1):
            if dp[c][r] == 0: continue
            
            for one in range(num[c]+1):
                nxt = (r-one) + (num[c]-one)
                if nxt > row or r < one: continue
                cases = (comb[r][one] * comb[row-r][num[c]-one]) % MOD
                dp[c+1][nxt] += (dp[c][r] * cases) % MOD
                
    return dp[col][row]


a = [[0,1,0],[1,1,1],[1,1,0],[0,1,1]]
print(solution(a)) # 6

a = [[1,0,0],[1,0,0]]
print(solution(a)) # 0

a = [[1,0,0,1,1],[0,0,0,0,0],[1,1,0,0,0],[0,0,0,0,1]]
print(solution(a)) # 72
