import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

data = [list(input()) for _ in range(12)]

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(x, y):
    q = deque()
    q.append([x, y])
    tmp.append([x, y])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < 12) and (0 <= ny < 6) and data[nx][ny] == data[x][y] and not visited[nx][ny]:
                q.append([nx, ny])
                tmp.append([nx, ny])
                visited[nx][ny] = 1
                
def delete(tmp):
    for a,b in tmp:
        data[a][b] = "."

def down():
    for i in range(6):
        for j in range(10, -1, -1):
            for k in range(11, j, -1):
                if data[j][i] != '.' and data[k][i] == ".":
                    data[k][i] = data[j][i]
                    data[j][i] = "."
                    break


time = 0
while True:
    flag = False
    visited = [[0]*6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if data[i][j] != "." and not visited[i][j]:
                visited[i][j] = 1
                tmp = []
                bfs(i, j)
                if len(tmp) >= 4:
                    flag = True
                    delete(tmp)
    if not flag:
        break
    down()
    time += 1
    
print(time)
