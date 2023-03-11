import sys
def input(): return sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(x, y, z):
    q = deque()
    q.append((x, y, z))

    while q:
        a, b, c = q.popleft()
        if (a, b) == (n-1, m-1):
            return visited[a][b][c]
        for i in range(4):
            nx, ny = a+dx[i], b+dy[i]
            if not (0 <= nx < n and 0 <= ny < m):
                continue
            if graph[nx][ny] == 1 and c == 0 :
                visited[nx][ny][1] = visited[a][b][0] + 1
                q.append((nx, ny, 1))
            elif graph[nx][ny] == 0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[a][b][c] + 1
                q.append((nx, ny, c))
    return -1


n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]

visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1

print(bfs(0, 0, 0))
