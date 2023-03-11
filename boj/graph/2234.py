import sys
def input(): return sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0] # 동서남북
dir = [1, 2, 4, 8]

def bfs(x, y, cnt):
    q.append([x, y])
    visited[x][y] = cnt
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < m) and (0 <= ny < n):
                if dir[i] & ~board[nx][ny] and visited[nx][ny] == 0:
                    visited[nx][ny] = cnt
                    q.append([nx, ny])


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
visited = [[0]*n for _ in range(m)]
q = deque()

cnt = 1
for i in range(m):
    for j in range(n):
        if visited[i][j] == 0:
            bfs(i, j, cnt)
            cnt += 1
print(cnt-1)

ans = [0]*(cnt-1)
for i in range(m):
    for j in range(n):
        ans[visited[i][j]-1] += 1
print(max(ans))

max_room = 0
for i in range(m):
    for j in range(n):
        for k in range(4):
            ni, nj = i+dx[k], j+dy[k]
            if 0 <= ni < m and 0 <= nj < n:
                if visited[i][j] != visited[ni][nj]:
                    room = ans[visited[i][j]-1] + ans[visited[ni][nj]-1]
                    max_room = max(max_room, room)
print(max_room)
