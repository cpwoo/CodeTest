from collections import deque

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

def solution(board):
    result = 10000
    N = len(board)
    dp = [[[10000]*N for _ in range(N)] for _ in range(4)]
    q = deque()
    q.append([0, 0, 0, 0])
    q.append([0, 0, 0, 1])
    while q:
        x, y, m, d = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < N) and (0 <= ny < N) and board[nx][ny] == 0:
                nm = m+1
                if d != i:
                    nm += 5
                if nm < dp[i][nx][ny]:
                    dp[i][nx][ny] = nm
                    if (nx, ny) == (N-1, N-1):
                        continue
                    q.append([nx, ny, nm, i])
    for i in range(4):
        result = min(result, dp[i][N-1][N-1])
    return result * 100


board = [[0,0,0],[0,0,0],[0,0,0]]
print(solution(board)) # 900

board = [[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]
print(solution(board)) # 3800

board = [[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]
print(solution(board)) # 2100

board = [[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]
print(solution(board)) # 3200
