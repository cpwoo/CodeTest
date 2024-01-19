import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1,1,0,0], [0,0,-1,1]

n, m = map(int, input().split())

before = [list(map(int, input().split())) for _ in range(n)]
after = [list(map(int, input().split())) for _ in range(n)]

cnt = 0
flag = True
for i in range(n):
    for j in range(m):
        if before[i][j] != after[i][j]:
            if cnt >= 1:
                flag = False
            else:
                cnt += 1

                bef, aft = before[i][j], after[i][j]
                before[i][j] = aft

                visited = [[0]*m for _ in range(n)]
                visited[i][j] = 1
                
                q = deque()
                q.append((i, j))
                
                while q:
                    x, y = q.popleft()
                    for d in range(4):
                        nx, ny = x+dx[d], y+dy[d]
                        if (0 <= nx < n) and (0 <= ny < m):
                            if before[nx][ny] == bef and not visited[nx][ny]:
                                before[nx][ny] = aft
                                visited[nx][ny] = 1
                                q.append((nx, ny))

for i in range(n):
    for j in range(m):
        if before[i][j] != after[i][j]:
            flag = False
            break


print("YES" if flag else "NO")
