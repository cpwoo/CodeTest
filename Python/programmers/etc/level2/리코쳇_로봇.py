from collections import deque

dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]

def solution(board):
    R, C = len(board), len(board[0])
    visited = [[0]*C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if board[i][j] == "R":
                cr, cc = i, j
    visited[cr][cc] = 1
    q = deque()
    q.append((cr, cc))
    while q:
        cr, cc = q.popleft()
        if board[cr][cc] == "G":
            return visited[cr][cc]-1
        for d in range(4):
            nr, nc = cr, cc
            while True:
                nr, nc = nr+dr[d], nc+dc[d]
                if (0 <= nr < R) and (0 <= nc < C) and board[nr][nc] == "D":
                    nr, nc = nr-dr[d], nc-dc[d]
                    break
                if not ((0 <= nr < R) and (0 <= nc < C)):
                    nr, nc = nr-dr[d], nc-dc[d]
                    break
            if not visited[nr][nc]:
                visited[nr][nc] = visited[cr][cc] + 1
                q.append((nr, nc))
    return -1


board = ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]
print(solution(board)) # 7

board = [".D.R", "....", ".G..", "...D"]
print(solution(board)) # -1
