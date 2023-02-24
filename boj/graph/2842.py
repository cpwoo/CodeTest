import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx = [1, 0, -1, 0, -1, 1, 1, -1]
dy = [0, 1, 0, -1, 1, 1, -1, -1]

n = int(input())
board = [list(input()) for _ in range(n)]
tiredness = [list(map(int, input().split())) for _ in range(n)]
houses = 0
fatigue = []

for i in range(n):
    for j in range(n):
        if board[i][j] == "P":
            sx, sy = i, j
        elif board[i][j] == "K":
            houses += 1
        fatigue.append(tiredness[i][j])
    
fatigue = sorted(set(fatigue))
left, right = 0, 0
ans = sys.maxsize

while left < len(fatigue):
    visited = [[False]*n for _ in range(n)]
    tired = tiredness[sx][sy]
    q = deque()
    k = 0

    if fatigue[left] <= tired <= fatigue[right]:
        visited[sx][sy] = True
        q.append((sx, sy))
    
    while q:
        x, y = q.popleft()
        for d in range(8):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < n) and (0 <= ny < n):
                if visited[nx][ny]: continue
                tired = tiredness[nx][ny]
                if fatigue[left] <= tired <= fatigue[right]:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    if board[nx][ny] == "K": k += 1
    
    if k == houses:
        ans = min(ans, fatigue[right]-fatigue[left])
        left += 1
    elif right+1 < len(fatigue):
        right += 1
    else:
        break

print(ans)
