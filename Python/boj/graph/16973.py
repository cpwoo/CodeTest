import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(x,y):
    q = deque()
    q.append([x,y,0])
    visited[x][y] = True
    while q:
        x, y, cnt = q.popleft()
        if (x, y) == (fr-1, fc-1):
            return cnt
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < n-(h-1)) and (0 <= ny < m-(w-1)) and not visited[nx][ny] and check(nx,ny):
                q.append([nx,ny,cnt+1])
    return -1


def check(x,y):
    visited[x][y] = True
    for i,j in walls:
        if (x <= i < x+h) and (y <= j < y+w):
            return False
    return True


n , m = map(int, input().split())
board = []
walls = []
for i in range(n):
    row = list(map(int, input().split()))
    for j in range(m):
        if row[j]:
            walls.append([i,j])
    board.append(row)
h, w, sr, sc, fr, fc = map(int, input().split())
visited = [[0]*m for _ in range(n)]

print(bfs(sr-1,sc-1))
