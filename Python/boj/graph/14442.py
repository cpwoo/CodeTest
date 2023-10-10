import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    visited = [[[-1]*(K+1) for _ in range(M)] for _ in range(N)]
    q = deque()
    q.append([0, 0, K])
    visited[0][0][K] = 1
    while q:
        x, y, z = q.popleft()
        if (x, y) == (N-1, M-1):
            return visited[x][y][z]
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if board[nx][ny] == 1 and z>0 and visited[nx][ny][z-1] == -1:
                    visited[nx][ny][z-1] = visited[x][y][z]+1
                    q.append([nx, ny, z-1])
                elif board[nx][ny] == 0 and visited[nx][ny][z] == -1:
                    visited[nx][ny][z] = visited[x][y][z]+1
                    q.append([nx, ny, z])
    return -1


N, M, K = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]

print(bfs())
