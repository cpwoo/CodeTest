import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations
from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(green, red):
    gq, rq = deque([]), deque([])
    flower = 0
    cnt = 1
    
    for i in green:
        visited[i[0]][i[1]] = -2
        gq.append(i)
    
    for i in red:
        visited[i[0]][i[1]] = -2
        rq.append(i)

    while gq and rq:
        for _ in range(len(gq)):
            x, y = gq.popleft()
            if visited[x][y] == -3:
                continue
            for d in range(4):
                nx, ny = x+dx[d], y+dy[d]
                if (0 <= nx < N) and (0 <= ny < M):
                    if board[nx][ny] and visited[nx][ny] == -1:
                        visited[nx][ny] = cnt
                        gq.append((nx, ny))
        
        for _ in range(len(rq)):
            x, y = rq.popleft()
            if visited[x][y] == -3:
                continue
            for d in range(4):
                nx, ny = x+dx[d], y+dy[d]
                if (0 <= nx < N) and (0 <= ny < M):
                    if board[nx][ny] and visited[nx][ny] == -1:
                        visited[nx][ny] = -2
                        rq.append((nx, ny))
                    elif board[nx][ny] and visited[nx][ny] == cnt:
                        flower += 1
                        visited[nx][ny] = -3
        cnt += 1
    return flower


N, M, G, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

location = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            location.append((i, j))

answer = 0
for i in combinations(location, G+R):
    for green in combinations(i, G):
        visited = [[-1]*M for _ in range(N)]
        red = [x for x in i if x not in green]
        tmp = bfs(green, red)
        answer = max(answer, tmp)

print(answer)
