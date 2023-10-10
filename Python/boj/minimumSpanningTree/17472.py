import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *
from collections import deque

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x, y = find(x), find(y)
    parent[y] = x

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
land = dict()
arr = []

landNum = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and not visited[i][j]:
            q = deque()
            q.append((i, j))
            visited[i][j] = True
            land[(i, j)] = landNum
            arr.append((i, j, landNum))

            while q:
                x, y = q.popleft()
                for a,b in move:
                    nx, ny = x+a, y+b
                    if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and board[nx][ny]:
                        q.append((nx, ny))
                        visited[nx][ny] = True
                        land[(nx, ny)] = landNum
                        arr.append((nx, ny, landNum))
            landNum += 1

edges = []
for x, y, curLand in arr:
    for a,b in move:
        dist = 0
        nx, ny = x+a, y+b
        while True:
            if 0 <= nx < n and 0 <= ny < m:
                toLand = land.get((nx, ny))

                if curLand == toLand:
                    break
                if toLand == None:
                    nx += a; ny += b
                    dist += 1
                    continue
                if dist < 2:
                    break
                edges.append((dist, curLand, toLand))
                break
            else:
                break

edges = sorted(edges, reverse=True)

ans = 0
cnt = landNum-1
parent = list(range(landNum))
while cnt:
    try:
        w, a, b = edges.pop()
    except:
        print(-1)
        sys.exit()
    if find(a) != find(b):
        union(a, b)
        ans += w
        cnt -= 1

print(ans)
