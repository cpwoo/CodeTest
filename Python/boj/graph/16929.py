import sys
input = lambda: sys.stdin.readline().rstrip()

dr, dc = [-1, 1, 0, 0], [0, 0, -1, 1]

def dfs(r, c, sr, sc):
    if visited[r][c]:
        print("Yes")
        exit()

    visited[r][c] = 1
    for d in range(4):
        nr, nc = r+dr[d], c+dc[d]
        if not (0 <= nr < N and 0 <= nc < M) or board[nr][nc] != board[r][c]:
            continue
        if (nr, nc) == (sr, sc):
            continue
        dfs(nr, nc, r, c) 


N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
visited = [[0]*M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if not visited[i][j]:
            dfs(i, j, -1, -1)
print("No")
