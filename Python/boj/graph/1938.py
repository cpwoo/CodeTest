import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def move(y, x, d, c):
    if c == 4:
        if 1 <= y < n-1 and 1 <= x < n-1:
            for i in range(y-1, y+2):
                for j in range(x-1, x+2):
                    if matrix[i][j] == "1":
                        return [y, x, d]
            return [y, x, 1-d]
    else:
        nx, ny = x+dx[c], y+dy[c]
        if d == 0:
            if 0 <= ny < n and 1 <= nx < n-1:
                if matrix[ny][nx-1] != "1" and matrix[ny][nx] != "1" and matrix[ny][nx+1] != "1":
                    return [ny, nx, d]
        elif d == 1:
            if 1 <= ny < n-1 and 0 <= nx < n:
                if matrix[ny-1][nx] != "1" and matrix[ny][nx] != "1" and matrix[ny+1][nx] != "1":
                    return [ny, nx, d]
    return [y, x, d]


def bfs(start):
    visited = [[[0]*n for _ in range(n)] for _ in range(2)]
    y, x, d = start
    visited[d][y][x] = 1
    q = deque()
    q.append([y, x, d, 0])

    while q:
        y, x, d, cnt = q.popleft()

        for i in range(5):
            ny, nx, nd = move(y, x, d, i)

            if visited[nd][ny][nx] == 0:
                if [ny, nx, nd] == end:
                    print(cnt+1)
                    return
                visited[nd][ny][nx] = 1
                q.append([ny, nx, nd, cnt+1])
    print(0)


n = int(input())
matrix = [list(input()) for _ in range(n)]

start, end = [], []

for i in range(n):
    for j in range(n):
        if len(start) == 0 and matrix[i][j] == "B":
            if i < n-1 and matrix[i+1][j] == "B":
                start = [i+1, j, 1]
                for k in range(3):
                    matrix[i+k][j] = "0"
            elif j < n-1 and matrix[i][j+1] == "B":
                start = [i, j+1, 0]
                for k in range(3):
                    matrix[i][j+k] = "0"

            continue

        if len(end) == 0 and matrix[i][j] == "E":
            if i < n-1 and matrix[i+1][j] == "E":
                end = [i+1, j, 1]
            elif j < n-1 and matrix[i][j+1] == "E":
                end = [i, j+1, 0]
            
            continue

bfs(start)
