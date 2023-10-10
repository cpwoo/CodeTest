import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    while q:
        x,y = q.popleft()
        if graph[Dx][Dy] == 'S':
            return visited[Dx][Dy]
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < N) and (0 <= ny < M):
                if (graph[nx][ny] == '.' or graph[nx][ny] == 'D') and graph[x][y] == 'S':
                    graph[nx][ny] = 'S'
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx,ny))
                elif (graph[nx][ny] =='.' or graph[nx][ny] =='S') and graph[x][y] == '*':
                    graph[nx][ny] = '*'
                    q.append((nx,ny))
    return "KAKTUS"


N, M = map(int, input().split())
graph = [list(input()) for _ in range(N)]
visited = [[0]*M for _ in range(N)]
q = deque()

for i in range(N):
    for j in range(M):
        if graph[i][j] == 'S':
            q.append([i, j])
        elif graph[i][j] == 'D':
            Dx, Dy = i, j

for i in range(N):
    for j in range(M):
        if graph[i][j] == '*':
            q.append([i, j])
                
print(bfs())
