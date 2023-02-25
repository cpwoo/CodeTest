import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(i, j, total):
    global answer
    if j == m:
        i += 1
        j = 0
    
    if i == n:
        answer = max(answer, total)
        return
    
    if not visited[i][j]:
        for k in range(4):
            a, b, c, d = shape[k]
            px, py, qx, qy = i+a, j+b, i+c, j+d
            if (0 <= px < n) and (0 <= qx < n) and (0 <= py < m) and (0 <= qy < m) and not visited[px][py] and not visited[qx][qy]:
                visited[px][py] = visited[qx][qy] = visited[i][j] = True
                dfs(i, j+1, total + board[i][j]*2 + board[px][py] + board[qx][qy])
                visited[px][py] = visited[qx][qy] = visited[i][j] = False
    dfs(i, j+1, total)

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
shape = {0 :[0,-1,1,0], 1:[-1,0,0,-1], 2:[-1,0,0,1], 3:[0,1,1,0]}
visited = [[False]*m for _ in range(n)]
answer = 0

dfs(0, 0, 0)
print(answer)
