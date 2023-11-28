import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

def bfs(x, y, k):
    c[x][y] = 1
    q.append((x, y))
    cnt = 0
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < n) and (0 <= ny < m):
                if c[nx][ny] == 0 and arr[nx][ny] == k:
                    cnt += 1
                    c[nx][ny] = 1
                    q.append((nx, ny))
    return cnt


n, m, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dice = [1, 2, 3, 4, 5, 6]

x, y, d, ans = 0, 0, 0, 0

for _ in range(k):
    if not (0 <= x+dx[d] < n and 0 <= y+dy[d] < m):
        d = (d+2)%4
    
    x, y = x+dx[d], y+dy[d]

    q = deque()
    c = [[0]*m for _ in range(n)]

    ans += (bfs(x,y,arr[x][y])+1)*arr[x][y]

    if d == 0:
        dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
    elif d == 1:
        dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]
    elif d == 2:
        dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
    else:
        dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
    
    if dice[5] > arr[x][y]:
        d = (d+1)%4
    elif dice[5] < arr[x][y]:
        d = (d+3)%4

print(ans)
