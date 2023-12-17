import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [1,-1,0,0,1,1,-1,-1], [0,0,1,-1,1,-1,-1,1]

def search(x, y):
    global flag
    visited[x][y] = True
    for d in range(8):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < m):
            if graph[x][y] < graph[nx][ny]:
                flag = 0
            if not visited[nx][ny] and graph[x][y] == graph[nx][ny]:
                search(nx, ny)


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

ret = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] > 0 and not visited[i][j]:
            flag = 1
            search(i, j)
            ret += flag

print(ret)
