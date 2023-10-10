import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    q = deque()
    q.append([0, 0])
    visited[0][0] = 1
    cnt = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < n) and (0 <= ny < m) and not visited[nx][ny]:
                if cheese[nx][ny] == 0:
                    visited[nx][ny] = 1
                    q.append([nx, ny])
                elif cheese[nx][ny] == 1:
                    cheese[nx][ny] = 0
                    visited[nx][ny] = 1
                    cnt += 1
    ans.append(cnt)
    return cnt

n, m = map(int, input().split())
cheese = [list(map(int, input().split())) for _ in range(n)]
ans = []

time = 0
while True:
    time += 1
    visited = [[0]*m for _ in range(n)]
    cnt = bfs()
    if cnt == 0:
        break

print(time-1)
print(ans[-2])
