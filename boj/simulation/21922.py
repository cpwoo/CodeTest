import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(board, q):
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1] # 좌우상하
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = dx[d], dy[d]
            r, c = x + nx, y + ny
            while (0 <= r < n) and (0 <= c < m):
                visited[r][c] = True
                if board[r][c] == 9:
                    break
                if board[r][c] == 3:
                    nx, ny = -ny, -nx
                elif board[r][c] == 4:
                    nx, ny = ny, nx
                elif (board[r][c] == 1 and nx == 0) or (board[r][c] == 2 and ny == 0):
                    break
                r += nx
                c += ny
    answer = 0
    for v in visited:
        answer += v.count(True)
    return answer


n, m = map(int, input().split())
visited = [[False]*m for _ in range(n)]

q = deque()

board = []
for r in range(n):
    row = list(map(int, input().split()))
    for c in range(m):
        if row[c] == 9:
            q.append((r, c))
            visited[r][c] = True
    board.append(row)
    
print(bfs(board, q))
