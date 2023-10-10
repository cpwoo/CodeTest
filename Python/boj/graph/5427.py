import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    cnt = 0
    while q:
        cnt += 1

        while fire and fire[0][2] < cnt:
            x, y, time = fire.popleft()
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
                if (0 <= nx < h) and (0 <= ny < w):
                    if board[nx][ny] == '.' or board[nx][ny] == "@":
                        board[nx][ny] = "*"
                        fire.append([nx, ny, time+1])

        while q and q[0][2] < cnt:
            x, y, time = q.popleft()
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
                if (0 <= nx < h) and (0 <= ny < w):
                    if board[nx][ny] == '.' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append([nx, ny, time+1])
                else:
                    return cnt    
    return "IMPOSSIBLE"

for _ in range(int(input())):
    w, h = map(int, input().split())

    q = deque()
    fire = deque()

    board = []
    visited = [[False]*w for _ in range(h)]

    for i in range(h):
        board.append(list(input()))
        for j in range(w):
            if board[i][j] == "@":
                visited[i][j] = True
                q.append([i, j, 0])
            elif board[i][j] == "*":
                fire.append([i, j, 0])

    print(bfs())
