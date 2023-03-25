import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

def bfs():
    while q:
        x, y, c, cnt = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < n) and (0 <= ny < m) and s[nx][ny] != "#" and visited[nx][ny][c] == 0:
                if s[nx][ny] == ".":
                    visited[nx][ny][c] = 1
                    q.append([nx, ny, c, cnt+1])
                elif s[nx][ny] == "1":
                    return cnt+1
                else:
                    if s[nx][ny].isupper():
                        if c & (1 << ord(s[nx][ny])-65):
                            visited[nx][ny][c] = 1
                            q.append([nx, ny, c, cnt+1])
                    elif s[nx][ny].islower():
                        nc = c | (1 << ord(s[nx][ny])-97)
                        if visited[nx][ny][c] == 0:
                            visited[nx][ny][c] = 1
                            q.append([nx, ny, nc, cnt+1])
    return -1 


n, m = map(int, input().split())
s = []
q = deque()
visited = [[[0]*64 for _ in range(m)] for _ in range(n)]

for i in range(n):
    a = list(input())
    s.append(a)
    for j in range(m):
        if a[j] == "0":
            q.append([i, j, 0, 0])
            s[i][j] = "."
            visited[i][j][0] = 1

print(bfs())
