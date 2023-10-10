import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1] # 상하좌우 4개
hx = [-2, -1, 1, 2, 2, 1, -1, -2]
hy = [1, 2, 2, 1, -1, -2, -2, -1] # 말이 움직일 수 있는 좌표 8개

def bfs():
    q = deque()
    q.append((0, 0, k, 0))
    visited = [[[False for _ in range(k+1)] for _ in range(w)] for _ in range(h)]
    visited[0][0][k] = True
    while q:
        x, y, z, cnt = q.popleft()
        if (x, y) == (h-1, w-1): return cnt
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < h) and (0 <= ny < w) and s[nx][ny] != 1 and not visited[nx][ny][z]:
                visited[nx][ny][z] = True
                q.append((nx, ny, z, cnt+1))
        if z > 0:
            for i in range(8):
                nx, ny = x+hx[i], y+hy[i]
                if (0 <= nx < h) and (0 <= ny < w) and s[nx][ny] != 1 and not visited[nx][ny][z-1]:
                    visited[nx][ny][z-1] = True
                    q.append((nx, ny, z-1, cnt+1))
    return -1


k = int(input())
w, h = map(int, input().split())
s = [list(map(int, input().split())) for _ in range(h)]
print(bfs())
