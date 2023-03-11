import sys
def input(): return sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**5)

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dfs(x, y):
    global cnt
    if not (0 <= x < num and 0 <= y < num):
        return False
    if arr[x][y] == 1:
        arr[x][y] = cnt
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            dfs(nx, ny)
        return True

def bfs(n):
    global ans
    check = [[-1]*num for _ in range(num)]
    q = deque()

    for i in range(num):
        for j in range(num):
            if arr[i][j] == n:
                q.append((i,j))
                check[i][j] = 0
    while q:
        x,y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if not (0 <= nx < num and 0 <= ny < num):
                continue
            if arr[nx][ny] > 0 and arr[nx][ny] != n:
                ans = min(ans, check[x][y])
                return
            if arr[nx][ny] == 0 and check[nx][ny] == -1:
                check[nx][ny] = check[x][y]+1
                q.append((nx, ny))


num = int(input())
arr = [list(map(int,input().split())) for _ in range(num)]

cnt = 2
for i in range(num):
    for j in range(num):
        if dfs(i,j): cnt += 1

ans = sys.maxsize
for i in range(2,cnt): bfs(i)

print(ans)
