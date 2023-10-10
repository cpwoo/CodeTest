import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]
direction = {1: [[0],[1],[2],[3]], 2:[[0,2],[1,3]], 3:[[0,1],[1,2],[2,3],[3,0]],
            4: [[0,1,2],[1,2,3],[2,3,0],[3,0,1]], 5:[[0,1,2,3]]}
            
def watch(x, y, direction, tmp):
    for d in direction:
        nx, ny = x, y
        while True:
            nx += dx[d]
            ny += dy[d]
            if not (0 <= nx < n and 0 <= ny < m) or tmp[nx][ny] == 6:
                break
            elif tmp[nx][ny] == 0:
                tmp[nx][ny] = '#'
                
def dfs(n, board):
    global ans
    tmp = deepcopy(board)
    
    if n == len(cctv):
        count = 0
        for t in tmp:
            count += t.count(0)
        ans = min(ans, count)
        return
    
    x, y, c = cctv[n]
    for d in direction[c]:
        watch(x, y, d, tmp)
        dfs(n+1, tmp)
        tmp = deepcopy(board)


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

cctv = []
ans = sys.maxsize

for i in range(n):
    for j in range(m):
        if board[i][j] != 0 and board[i][j] != 6:
            cctv.append([i, j, board[i][j]])

dfs(0, board)
print(ans)
