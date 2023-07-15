import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from itertools import permutations

INF = sys.maxsize

dr, dc = [1, -1, 0, 0], [0, 0, 1, -1]

def bfs(i, j):
    visited = [[0]*w for _ in range(h)]
    visited[i][j] = 1
    q = deque()
    q.append((i, j))
    while q:
        r, c = q.popleft()
        for i in range(4):
            nr, nc = r+dr[i], c+dc[i]
            if (0 <= nr < h) and (0 <= nc < w) and not visited[nr][nc]:
                if board[nr][nc] != "x":
                    q.append((nr, nc))
                    visited[nr][nc] = visited[r][c]+1
    return visited


while True:
    w, h = map(int, input().split())
    if (w, h) == (0, 0):
        break
    board = [list(input()) for _ in range(h)]
    
    target = []
    for r in range(h):
        for c in range(w):
            if board[r][c] == "o":
                cr, cc = r, c
            elif board[r][c] == "*":
                target.append((r, c))

    n = len(target)
    d = [0]*n
    visited = bfs(cr, cc)
    flag = True

    for idx, (r, c) in enumerate(target):
        tmp = visited[r][c]
        if not tmp:
            print(-1)
            flag = False
            break
        d[idx] += tmp-1
    
    if flag:
        dist = [[0]*n for _ in range(n)]
        for i in range(n-1):
            visited = bfs(target[i][0], target[i][1])
            for j in range(i+1, n):
                dist[i][j] = dist[j][i] = visited[target[j][0]][target[j][1]]-1
        ans = INF
        for p in permutations(range(n)):
            tmp = d[p[0]]
            start = p[0]
            for idx in range(1, n):
                end = p[idx]
                tmp += dist[start][end]
                start = end
            ans = min(ans, tmp)
        print(ans)
