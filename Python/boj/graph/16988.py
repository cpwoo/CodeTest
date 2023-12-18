import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations
from collections import deque

dx, dy = [-1,1,0,0], [0,0,-1,1]

def cnt(can):
    visited = [[0]*m for _ in range(n)]    
    for i, j in can:
        board[i][j] = 1

    ret = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 2 and not visited[i][j]:
                ret += bfs(i, j, visited)
    
    for i, j in can:
        board[i][j] = 0
    
    return ret


def bfs(i, j, visited):
    q = deque()
    q.append((i, j))
    visited[i][j] = 1
    flag = True

    ret = 1
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < n) and (0 <= ny < m) and not visited[nx][ny]:
                if board[nx][ny] == 0:
                    flag = False
                elif board[nx][ny] == 2:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    ret += 1
    
    return ret if flag else 0


n, m = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]

cand = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            cand.append((i, j))

L = len(cand)
answer = 0

for can in combinations(cand, 2):
    answer = max(answer, cnt(can))

print(answer)
