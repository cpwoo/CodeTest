import sys
input = lambda : sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

visited = [[0]*M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if board[i][j]:
            visited[i][j] = -1

q = deque()

cnt = 1
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0:
            q = deque()
            q.append((i, j))
            visited[i][j] = cnt
            while q:
                x, y = q.popleft()
                for d in range(4):
                    nx, ny = (x+dx[d]+N)%N, (y+dy[d]+M)%M
                    if visited[nx][ny] == 0:
                        visited[nx][ny] = cnt
                        q.append((nx, ny))
            cnt += 1

ret = 0
for i in range(N):
    for j in range(M):
        ret = max(ret, visited[i][j])

print(ret)
