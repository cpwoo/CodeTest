import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

def bfs(i, j):
    q = deque()
    q.append([i, j])
    visited = [[0]*m for _ in range(n)]
    visited[i][j] = 1
    cnt = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < n) and (0 <= ny < m) and board[nx][ny] == "L" and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y]+1
                cnt = max(cnt, visited[nx][ny])
                q.append([nx, ny])
    return cnt-1

n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

_max = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == "L":
            _max = max(_max, bfs(i, j))

print(_max)
