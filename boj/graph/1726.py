import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [0, 0, 0, 1, -1], [0, 1, -1, 0, 0]

def bfs():
    q = deque()
    q.append((sx-1, sy-1, sd, 0))
    visited = [[[0 for _ in range(5)] for _ in range(n)] for _ in range(m)]
    visited[sx-1][sy-1][sd] = 1

    while q:
        x, y, d, cnt = q.popleft()
        if (x, y, d) == (ex-1, ey-1, ed): return cnt
        nx, ny = x, y
        for _ in range(3):
            nx += dx[d]
            ny += dy[d]
            if (0 <= nx < m) and (0 <= ny < n) and visited[nx][ny][d]: continue
            if (0 <= nx < m) and (0 <= ny < n) and board[nx][ny] != 1:
                visited[nx][ny][d] = 1
                q.append((nx, ny, d, cnt+1))
            else: break
        for i in range(1, 5):
            if d != i and not visited[x][y][i]:
                visited[x][y][i] = 1
                if (d, i) == (1, 2) or (d, i) == (2, 1) or (d, i) == (3, 4) or (d, i) == (4, 3):
                    q.append((x, y, i, cnt+2))
                else:
                    q.append((x, y, i, cnt+1))


m, n = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
sx, sy, sd = map(int, input().split())
ex, ey, ed = map(int, input().split())
print(bfs())
