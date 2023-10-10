import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    gram = 10001
    q.append((0, 0))
    visited[0][0] = 1
    while q:
        x, y = q.popleft()
        if (x, y) == (n-1, m-1):
            return min(visited[x][y]-1, gram)
        if graph[x][y] == 2:
            gram = visited[x][y]-1 + n-1-x + m-1-y
            
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if (0 <= nx < n) and (0 <= ny < m) and not visited[nx][ny]:
                if graph[nx][ny] == 0 or graph[nx][ny] == 2:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))
    return gram


n, m, t = map(int, input().rstrip().split())
graph = [list(map(int, input().split())) for _ in range(n)]
q = deque()
visited = [[0]*m for _ in range(n)]

result = bfs()
print(result if result <= t else 'Fail')
