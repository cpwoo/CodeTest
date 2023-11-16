import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(m, n, arr):
    # candy[i][j][0] -> (i,j) 뽑지 않았을 때 max
    # candy[i][j][1] -> (i,j) 뽑았을 때 max
    candy = [[[0]*2 for _ in range(n)] for _ in range(m)]
    
    # 초기화 작업
    for i in range(m):
        candy[i][0][1] = arr[i][0]
    
    for i in range(m):
        for j in range(1, n):
            candy[i][j][0] = max(candy[i][j-1][0], candy[i][j-1][1])
            candy[i][j][1] = candy[i][j-1][0]+arr[i][j]

    # row[i] : i번째 행에서 얻을 수 있는 사탕 최대값
    row = [0]*m
    for i in range(m):
        tmp = 0
        for j in range(n):
            tmp = max(tmp, candy[i][j][0], candy[i][j][1])
        row[i] = tmp

    # dp[i][0] -> i행 뽑지 않았을 때 max
    # dp[i][1] -> i행 뽑았을 때 max
    dp = [[0]*2 for _ in range(m)]
    dp[0][1] = row[0]

    for i in range(1, m):
        dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        dp[i][1] = dp[i-1][0]+row[i]

    return max(dp[m-1][0], dp[m-1][1])


while True:
    m, n = map(int, input().split())    
    if (m,n) == (0,0): break
    arr = [list(map(int, input().split())) for _ in range(m)]
    print(solve(m, n, arr))
