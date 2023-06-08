import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

n, m, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

q = deque()
visited = [[-1]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j] == 3:
            q.append((i, j))
            visited[i][j] = 0

while q:
    x, y = q.popleft()
    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < m):
            if visited[x][y] < k and visited[nx][ny] == -1:
                if board[nx][ny] != 4:
                    board[nx][ny] = 3
                visited[nx][ny] = visited[x][y]+1
                q.append((nx, ny))

q = deque()
visited = [[-1]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j] == 4:
            q.append((i, j))
            visited[i][j] = 0

while q:
    x, y = q.popleft()
    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < m) and visited[nx][ny] == -1:
            if board[nx][ny] in [0, 2]:
                visited[nx][ny] = visited[x][y]+1
                q.append((nx, ny))

ans = -1
for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            if visited[i][j] != -1 and (ans == -1 or ans > visited[i][j]):
                ans = visited[i][j]
print(ans)
