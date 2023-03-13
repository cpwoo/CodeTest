import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**9)

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dfs(x, y, cnt):
    global result
    result = max(result, cnt)
    for i in range(4):
        nx = x+int(arr[x][y])*dx[i]
        ny = y+int(arr[x][y])*dy[i]
        if (0 <= nx < n) and (0 <= ny < m) and arr[nx][ny] != "H" and cnt+1 > dp[nx][ny]:
            if visited[nx][ny]:
                print(-1)
                exit()
            else:
                dp[nx][ny] = cnt+1
                visited[nx][ny] = True
                dfs(nx, ny, cnt+1)
                visited[nx][ny] = False


n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]

visited = [[False]*m for _ in range(n)]
dp = [[0]*m for _ in range(n)]

result = 0

dfs(0, 0, 0)
print(result+1)
