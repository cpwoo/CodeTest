from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def solution(maps):
    row, col = len(maps), len(maps[0])
    visited = [[[-1]*2 for _ in range(col)] for _ in range(row)]
    for i in range(row):
        for j in range(col):
            if maps[i][j] == "S":
                sx, sy = i, j
            elif maps[i][j] == "L":
                lx, ly = i, j
            elif maps[i][j] == "E":
                ex, ey = i, j
    q = deque()
    q.append([sx, sy, 0])
    visited[sx][sy][0] = 0
    while q:
        x, y, state = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if not (0 <= nx < row and 0 <= ny < col and maps[nx][ny] != "X"):
                continue
            if (nx, ny) == (lx, ly) and state == 0 and visited[nx][ny][1] == -1:
                visited[nx][ny][1] = visited[x][y][0]+1
                q.append([nx, ny, 1])
            if visited[nx][ny][state] == -1:
                visited[nx][ny][state] = visited[x][y][state]+1
                q.append([nx, ny, state])
                
    return visited[ex][ey][1]


maps = ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]
print(solution(maps)) # 16

maps = ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]
print(solution(maps)) # -1
