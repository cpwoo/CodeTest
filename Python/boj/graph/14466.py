import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1,1,0,0], [0,0,-1,1]

def bfs(r1, c1):
    q = deque()
    q.append((r1, c1))
    visited[r1][c1] = True

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < N) and (0 <= ny < N) and not visited[nx][ny]:
                if (nx, ny) not in graph[x][y]:
                    q.append((nx, ny))
                    visited[nx][ny] = True


N, K, R = map(int, input().split())
graph = [[[] for _ in range(N)] for _ in range(N)]

for _ in range(R):
    r1, c1, r2, c2 = map(lambda t: int(t)-1, input().split())
    graph[r1][c1].append((r2, c2))
    graph[r2][c2].append((r1, c1))

cows = [list(map(lambda t: int(t)-1, input().split())) for _ in range(K)]

cnt = 0
for i in range(K):
    visited = [[False]*N for _ in range(N)]
    bfs(cows[i][0], cows[i][1])
    for r2, c2 in cows[i+1:]:
        if not visited[r2][c2]:
            cnt += 1

print(cnt)
