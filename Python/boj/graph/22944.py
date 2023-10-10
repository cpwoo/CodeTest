import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def solve():
    visited = [[0]*N for _ in range(N)]
    q = deque([(sx, sy, H, 0, 0)])
    visited[sx][sy] = H
    
    while q:
        x, y, h, d, cnt = q.popleft()
        
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if (0 <= nx < N) and (0 <= ny < N):
                if board[nx][ny] == 'E':
                    return cnt+1
                nh, nd = h, d
                
                if board[nx][ny] == 'U':
                    nd = D
                    
                if nd == 0:
                    nh -= 1
                else:
                    nd -= 1
                
                if nh == 0:
                    continue
                
                if visited[nx][ny] < nh:
                    visited[nx][ny] = nh
                    q.append((nx, ny, nh, nd, cnt+1))
    return -1


N, H, D = map(int, input().split()) # 격자길이(N*N), 체력, 우산내구도
board = []
for x in range(N):
    board.append(list(input()))
    for y in range(N):
        if board[x][y] == 'S':
            sx, sy = x, y

print(solve())
