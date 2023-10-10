import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(i, j, num):
    q = deque()
    q.append([i, j])
    visited[i][j] = 1
    flag = True
    cnt = 1
    
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if nx == -1 or nx == n or ny == -1 or ny == m:
                flag = False
                continue
            if board[nx][ny] <= num and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append([nx, ny])
                cnt += 1
    
    return cnt if flag else 0


n, m = map(int, input().split())
board = [list(map(int, input())) for _ in range(n)]

res = 0
for num in range(1, 9):
    visited = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if board[i][j] <= num and not visited[i][j]:
                res += bfs(i, j, num)
print(res)
