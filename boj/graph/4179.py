import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [1, -1, 0, 0], [0, 0, -1, 1]

def bfs():
    global res
    
    while True:
        res += 1
        tmp = []
        while F:
            x, y = F.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if (-1 < nx < r) and (-1 < ny < c):
                    if board[nx][ny] == '.' or board[nx][ny] == '$':
                        tmp.append((nx, ny))
                        board[nx][ny] = 'F'
        F = deque(tmp)
        
        tmp = []
        while J:
            x, y = J.popleft()
            if x == 0 or y == 0 or x == r-1 or y == c-1:
                return res            
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if (-1 < nx < r) and (-1 < ny < c) and board[nx][ny] == '.':
                    tmp.append((nx, ny))
                    board[x][y] = '$'
                    board[nx][ny] = 'J'
        J = deque(tmp)
        if not J:
            return False


r, c = map(int, input().split())
board, res = [], 0

F, J = deque(), deque()

for i in range(r):
    data = list(input())
    for j in range(c):
        if data[j] == 'J':
            J.append((i, j))
        if data[j] == 'F':
            F.append((i, j))
            
    board.append(data)
        
print(res if bfs() else "IMPOSSIBLE")
