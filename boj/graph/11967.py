import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict, deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b, c, d = map(int, input().split())
    graph[(a-1, b-1)].append((c-1, d-1))

q = deque()
q.append((0, 0))
visited = [[0]*n for _ in range(n)]
on = [[0]*n for _ in range(n)]
visited[0][0] = on[0][0] = 1

cnt = 1
while q:
    x, y = q.popleft()
    for nx, ny in graph[(x, y)]:
        if not on[nx][ny]:
            on[nx][ny] = 1
            cnt += 1
            for d in range(4):
                nx, ny = nx+dx[d], ny+dy[d]
                if (0 <= nx < n) and (0 <= ny < n) and visited[nx][ny]:
                    q.append((nx, ny))
    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < n) and on[nx][ny] and not visited[nx][ny]:
            visited[nx][ny] = 1
            q.append((nx, ny))
    
print(cnt)
