import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
    
dx = [[1, 0, -1, -1, -1, 0], [1, 1, 0, -1, 0, 1]] # 줄의 짝홀 여부에 따라 다르게 사용
dy = [0, 1, 1, 0, -1, -1]

def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited = [[False for _ in range(w+2)] for _ in range(h+2)]
    visited[y][x] = True
    cnt = 0
    while q:
        y, x = q.popleft()
        for i in range(6):
            nx, ny = x+dx[y%2][i], y+dy[i]
            if (0 <= nx < w+2) and (0 <= ny < h+2):
                if matrix[ny][nx] == 0 and not visited[ny][nx]:
                    q.append((ny, nx))
                    visited[ny][nx] = True
                elif matrix[ny][nx] == 1:
                    cnt += 1
    return cnt


w, h = map(int, input().split())
matrix = [[0 for _ in range(w+2)] for _ in range(h+2)]
for i in range(1, h+1):
    matrix[i][1:w+1] = map(int, input().split())

print(bfs(0, 0))
