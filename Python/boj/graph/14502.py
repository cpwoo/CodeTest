import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from copy import deepcopy

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    global ans
    w = deepcopy(matrix)
    for i in range(n):
        for j in range(m):
            if w[i][j] == 2:
                q.append([i, j])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < n and 0 <= ny < m and w[nx][ny] == 0:
                w[nx][ny] = 2
                q.append([nx, ny])    
    cnt = 0
    for i in w:
        cnt += i.count(0)
    ans = max(ans, cnt)
    
def wall(x):
    if x == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if matrix[i][j] == 0:
                matrix[i][j] = 1
                wall(x+1)
                matrix[i][j] = 0


n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
ans = 0
q = deque()

wall(0)
print(ans)
