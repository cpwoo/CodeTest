import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]
INF = sys.maxsize

def bfs(case, q, visited):
    while q:
        r, c, to = q.popleft()
        if board[r][c] == "C":
            case.append([r, c, to])
        for k in range(4):
            if k == to:
                continue
            nr, nc = r+dr[k], c+dc[k]
            if (0 <= nr < n) and (0 <= nc < m) and board[nr][nc] != "#" and visited[nr][nc][k] == 0:
                visited[nr][nc][k] = visited[r][c][to] + 1
                q.append([nr, nc, k])

def dfs(d, sR, sC, to, cnt):
    global ans

    if ans <= d:
        return
    
    if cnt == 2:
        if d < ans:
            ans = d
        return
    
    visited = [[[0, 0, 0, 0] for _ in range(m)] for _ in range(n)]
    visited[sR][sC][to] = d
    q = deque([[sR, sC, to]])
    case = []
    bfs(case, q, visited)

    for nr, nc, nt in case:
        board[nr][nc] = "."
        dfs(visited[nr][nc][nt], nr, nc, nt, cnt+1)
        board[nr][nc] = "C"


n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if board[i][j] == "S":
            sR, sC = i, j
            break
board[sR][sC] = "."
ans = INF

for k in range(4):
    dfs(0, sR, sC, k, 0)

print(ans if ans != INF else -1)
