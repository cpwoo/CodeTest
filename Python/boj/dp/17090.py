import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(250000)

d = {"U":0,"R":1,"D":2,"L":3}
dx, dy = [-1,0,1,0],[0,1,0,-1]

def dfs(x, y):
    if (x < 0 or x >= n or y < 0 or y >= m): return 1
    
    if visited[x][y]: return visited[x][y]

    visited[x][y] = -1
    visited[x][y] = dfs(x+dx[d[board[x][y]]], y+dy[d[board[x][y]]])

    return visited[x][y]


n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

answer = 0

for i in range(n):
    for j in range(m):
        if dfs(i, j) == 1:
            answer += 1

print(answer)
