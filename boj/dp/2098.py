import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def solution(i, route):

    if dp[i][route] != 0:
        return dp[i][route]

    if route == (1<<(n-1))-1:
        if board[i][0] != 0:
            return board[i][0]
        else:
            return INF

    bound = INF

    for j in range(1, n):
        if board[i][j] == 0:
            continue
        if route & (1<<(j-1)):
            continue
        dist = board[i][j] + solution(j, route|(1<<(j-1)))
        if bound > dist:
            bound = dist
    
    dp[i][route] = bound

    return bound


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*((1<<n)-1) for _ in range(n)]

print(solution(0, 0))
