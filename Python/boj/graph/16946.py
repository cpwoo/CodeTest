import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(i, j):
    q = deque()
    visited[i][j] = 1
    q.append([i, j])
    cnt = 1
    while q:
        x, y = q.popleft()
        zeros[x][y] = group
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and not board[nx][ny]:
                q.append([nx, ny])
                visited[nx][ny] = 1
                cnt += 1
    return cnt

def move_count(x, y):
    data = set()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0 <= nx < n and 0 <= ny < m and zeros[nx][ny]:
            data.add(zeros[nx][ny])
    cnt = 1
    for c in data:
        cnt += info[c]
        cnt %= 10
    return cnt

n, m = map(int, input().split())
board = [list(map(int, input())) for _ in range(n)]

visited = [[0]*m for _ in range(n)]
zeros = [[0]*m for _ in range(n)]
answer = [[0]*m for _ in range(n)]

group = 1
info = {}

for i in range(n):
    for j in range(m):
        if not board[i][j] and not visited[i][j]:
            cnt = bfs(i, j)
            info[group] = cnt
            group += 1

for i in range(n):
    for j in range(m):
        if board[i][j]:
            answer[i][j] = move_count(i, j)

for row in answer:
    print(''.join(map(str, row)))
