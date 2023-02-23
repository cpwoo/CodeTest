import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy
from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def count_ocean(x, y):
    count = 0
    
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]        
        if (0 <= nx < n) and (0 <= ny < m) and tmp_graph[nx][ny] == 0:
            count += 1
    
    return count

def count_iceberg(start_x, start_y):
    q = deque()
    q.append([start_x, start_y])
    visited[start_x][start_y] = True
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            
            if (0 <= nx < n) and (0 <= ny < m) and graph[nx][ny] != 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny])


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
answer = 1

while True:
    visited = [[False]*m for _ in range(n)]
    piece = 0
    
    flag = True
    for i in range(n):
        for j in range(m):
            if graph[i][j] != 0:
                flag = False
    if flag:
        print(0)
        break
        
    tmp_graph = deepcopy(graph)
    for i in range(1, n-1):
        for j in range(1, m-1):
            if tmp_graph[i][j] != 0:
                graph[i][j] = max(0, graph[i][j]-count_ocean(i, j))
    
    for i in range(1, n-1):
        for j in range(1, m-1):
            if not visited[i][j] and graph[i][j] != 0:
                count_iceberg(i, j)
                piece += 1
    
    if piece >= 2:
        print(answer)
        break

    answer += 1
