import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(rx, ry, bx, by):
    q = deque()
    q.append([rx, ry, bx, by])
    visited = []
    visited.append([rx, ry, bx, by])
    cnt = 0
    while q:
        for _ in range(len(q)):
            rx, ry, bx, by = q.popleft()
            if cnt > 10:
                return 0
            if graph[rx][ry] == 'O':
                return 1
            for i in range(4):
                nrx, nry = rx, ry
                while True:
                    nrx += dx[i]
                    nry += dy[i]
                    if graph[nrx][nry] == '#':
                        nrx -= dx[i]
                        nry -= dy[i]
                        break
                    if graph[nrx][nry] == 'O':
                        break
                
                nbx, nby = bx, by
                while True:
                    nbx += dx[i]
                    nby += dy[i]
                    if graph[nbx][nby] == '#':
                        nbx -= dx[i]
                        nby -= dy[i]
                        break
                    if graph[nbx][nby] == 'O':
                        break
                
                if graph[nbx][nby] == 'O':
                    continue
                if (nrx, nry) == (nbx, nby):
                    if abs(nrx-rx) + abs(nry-ry) > abs(nbx-bx) + abs(nby-by):
                        nrx -= dx[i]
                        nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]
                
                if [nrx, nry, nbx, nby] not in visited:
                    q.append([nrx, nry, nbx, nby])
                    visited.append([nrx, nry, nbx, nby])
        cnt += 1    
    return 0


n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(input()))
    for j in range(m):
        if graph[i][j] == 'R':
            rx, ry = i, j
        elif graph[i][j] == 'B':
            bx, by = i, j

print(bfs(rx, ry, bx, by))
