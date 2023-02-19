import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**9)

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dfs(x, y):
    visited[x][y] = True
    current_color = board[x][y]

    for k in range(4):
        nx, ny = x+dx[k], y+dy[k]
        if (0 <= nx < n) and (0 <= ny < n) and not visited[nx][ny] and board[nx][ny] == current_color:
            dfs(nx, ny)


n = int(input())
board = [list(input()) for _ in range(n)]
visited = [[False]*n for _ in range(n)]

three_cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            three_cnt += 1

visited = [[False]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if board[i][j] == 'G':
            board[i][j] = 'R'

two_cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i, j)
            two_cnt += 1

print(three_cnt, two_cnt)
