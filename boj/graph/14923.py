import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

n, m = map(int, input().split())
Hx, Hy = map(lambda x: int(x)-1, input().split())
Ex, Ey = map(lambda x: int(x)-1, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

q = deque()
visited = [[[-1]*2 for _ in range(m)] for _ in range(n)]
q.append((Hx, Hy, 0))
visited[Hx][Hy][0] = 0

while q:
    x, y, state = q.popleft()
    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < m):
            if board[nx][ny] == 0 and visited[nx][ny][state] == -1:
                visited[nx][ny][state] = visited[x][y][state]+1
                q.append((nx, ny, state))
            if board[nx][ny] == 1 and state == 0 and visited[nx][ny][state+1] == -1:
                visited[nx][ny][state+1] = visited[x][y][state]+1
                q.append((nx, ny, state+1))

print(min(visited[Ex][Ey]))
