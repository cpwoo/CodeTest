import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

N, M = map(int, input().split())
x1, y1, x2, y2 = map(lambda t: int(t)-1, input().split())

graph = [list(input()) for _ in range(N)]

q = deque()
q.append((x1, y1, 1))

visited = [[False]*M for _ in range(N)]
visited[x1][y1] = True

while q:
    x, y, cnt = q.popleft()
    if (x, y) == (x2, y2):
        print(cnt)
        break
    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < N) and (0 <= ny < M) and not visited[nx][ny]:
            visited[nx][ny] = True
            if graph[nx][ny] == "1":
                q.append((nx, ny, cnt+1))
            else:
                q.appendleft((nx, ny, cnt))
