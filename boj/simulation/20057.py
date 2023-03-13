import sys
input = lambda: sys.stdin.readline().rstrip()

def wind(x, y, d):
    value = 0
    sand = data[x][y]
    sum_value = 0
    for i in range(9):
        nx, ny = x + windx[d][i], y + windy[d][i]
        wind_sand = (sand * rate[i]) // 100
        sum_value += wind_sand
        
        if not (0 <= nx < n and 0 <= ny < n):
            value += wind_sand
            continue
        else:
            data[nx][ny] += wind_sand
        
    nx, ny = x + dx[d], y + dy[d]
    a = sand - sum_value
    if not (0 <= nx < n and 0 <= ny < n):
        value += a
    else:
        data[nx][ny] += a
        
    data[x][y] = 0
    return value

def solve(x, y):
    value = 0
    visited = [[False]*n for _ in range(n)]
    d = -1
    while True:
        if (x, y) == (0, 0): break
        visited[x][y] = True
        nd = (d+1) % 4
        nx, ny = x + dx[nd], y + dy[nd]
        
        if visited[nx][ny]:
            nd = d
            nx, ny = x + dx[nd], y + dy[nd]
        value += wind(nx, ny, nd)
        x, y, d = nx, ny, nd
        
    return value


n = int(input())
x, y = n//2, n//2
data = [list(map(int, input().split())) for _ in range(n)]
dx, dy = [0, 1, 0, -1], [-1, 0, 1, 0]

windx = [
    # left
    [-1, 1, -2, 2, 0, -1, 1, -1, 1],
    # down
    [-1, -1, 0, 0, 2, 0, 0, 1, 1],
    # right
    [1, -1, 2, -2, 0, 1, -1, 1, -1],
    # up
    [1, 1, 0, 0, -2, 0, 0, -1, -1]
]
windy = [
    # left
    [1, 1, 0, 0, -2, 0, 0, -1, -1],
    # down
    [-1, 1, -2, 2, 0, -1, 1, -1, 1],
    # right
    [-1, -1, 0, 0, 2, 0, 0, 1, 1],
    # up
    [1, -1, 2, -2, 0, 1, -1, 1, -1]
]

rate = [1, 1, 2, 2, 5, 7, 7, 10, 10]

print(solve(x,y))
