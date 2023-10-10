import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [-1, 1, -1, 1], [-1, -1, 1, 1]

def check(x,y):
    if tmp[x][y]: return False
    return True

def bishop(x, y, num):
    global blank
    for i in range(n):
        for d in range(4):
            nx, ny = x + i*dx[d], y + i*dy[d]
            if (0 <= nx < n) and (0 <= ny < n):
                tmp[nx][ny] += num
    
def backtracking(idx, cnt):
    global ans
    if idx >= len(grid):
        ans = max(ans, cnt)
        return
    x, y = grid[idx]
    
    if check(x, y):
        bishop(x, y, 1)
        backtracking(idx+1, cnt+1)
        bishop(x, y, -1)
        backtracking(idx+1, cnt)
    else:
        backtracking(idx+1, cnt)


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

#짝수칸 백트래킹
tmp = [[0]*n for _ in range(n)]
grid, ans = [], 0
for i in range(n):
    for j in range(n):
        if board[i][j] and (i+j)%2 == 0:
            grid.append((i, j))
backtracking(0, 0)
res1 = ans

#홀수칸 백트래킹
tmp = [[0]*n for _ in range(n)]
grid, ans = [], 0
for i in range(n):
    for j in range(n):
        if board[i][j] and (i+j)%2 == 1:
            grid.append((i, j))
backtracking(0, 0)
res2 = ans

print(res1+res2)
