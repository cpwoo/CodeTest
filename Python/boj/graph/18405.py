from collections import deque

N, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

virus = []
for i in range(N):
    for j in range(N):
        if board[i][j] != 0:
            virus.append([board[i][j], i, j, 0])

S, X, Y = map(int, input().split())

virus.sort()
q = deque(virus)

while q:
    virus, x, y, time = q.popleft()
    if time == S:
        break
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 0:
            board[nx][ny] = virus
            q.append([board[nx][ny], nx, ny, time+1])

print(board[X-1][Y-1])
