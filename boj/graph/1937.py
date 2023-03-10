import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**9)

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dfs(x, y):
    if visited[x][y]: return visited[x][y]
    visited[x][y] = 1
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if (0 <= nx < n) and (0 <= ny < n) and board[x][y] < board[nx][ny]:
            visited[x][y] = max(visited[x][y], dfs(nx, ny)+1)
    return visited[x][y]


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*n for _ in range(n)]

ans = 0
for i in range(n):
    for j in range(n):
        ans = max(ans, dfs(i, j))

print(ans)
