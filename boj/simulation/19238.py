import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(x, y):
    visited = [[-1]*n for _ in range(n)]
    q = deque()
    q.append((x, y))
    visited[x][y] = 0
    
    while q:
        tx, ty = q.popleft()
        for i in range(4):
            nx, ny = tx + dx[i], ty + dy[i]            
            if (0 <= nx < n) and (0 <= ny < n) and graph[nx][ny] != 1 and visited[nx][ny] == -1:
                visited[nx][ny] = visited[tx][ty] + 1
                q.append((nx, ny))
                
    return visited

def dist(visited, people):
    i = 0
    for sx, sy, ex, ey in people:
        people[i].append(visited[sx-1][sy-1])
        i += 1
    
    people.sort(key=lambda t: (-t[4], -t[0], -t[1]))


n, m, fuel = map(int, input().split())
graph = list(list(map(int, input().split())) for _ in range(n))
x, y = map(int, input().split())
people = list(list(map(int, input().split())) for _ in range(m))

while people:
    visited = bfs(x-1, y-1)
    dist(visited, people)
    sx, sy, ex, ey, dist1 = people.pop()
    
    for tmp in people:
        tmp.pop()
        
    visited = bfs(sx-1, sy-1)
    dist2 = visited[ex-1][ey-1]
    x, y = ex, ey
    
    if dist1 == -1 or dist2 == -1:
        print(-1)
        exit()
    
    fuel -= dist1
    if fuel < 0:
        break
        
    fuel -= dist2
    if fuel < 0:
        break
        
    fuel += dist2*2
    
print(-1 if fuel < 0 else fuel)
