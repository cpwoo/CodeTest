def solution(board):
    answer = 0
    n, m = len(board), len(board[0])
    dp = [[0]*(m+1) for _ in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, m+1):
            if board[i-1][j-1] == 1:
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
                answer = max(answer, dp[i][j])
    return answer**2


board = [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]
print(solution(board)) # 9

board = [[0,0,1,1],[1,1,1,1]]
print(solution(board)) # 4
