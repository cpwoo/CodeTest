import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [0, 1], [1, 0]

def dfs(x, y, p):
    global _max, _min

    if (x, y) == (n-1, n-1):
        _max = max(_max, p)
        _min = min(_min, p)
        return
    
    for d in range(2):
        nx, ny = x+dx[d], y+dy[d]
        if nx == n or ny == n: continue
        if arr[x][y] == "*":
            dfs(nx, ny, p*int(arr[nx][ny]))
        elif arr[x][y] == "+":
            dfs(nx, ny, p+int(arr[nx][ny]))
        elif arr[x][y] == "-":
            dfs(nx, ny, p-int(arr[nx][ny]))
        else:
            dfs(nx, ny, p)


n = int(input())
arr = [list(input().split()) for _ in range(n)]
visited = [[0]*n for _ in range(n)]
visited[0][0] = 1

_max = -sys.maxsize
_min = sys.maxsize

dfs(0, 0, int(arr[0][0]))

print(_max, _min)
