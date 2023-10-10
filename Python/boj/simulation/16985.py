import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from itertools import permutations

INF = sys.maxsize

dz, dy, dx = [1,-1,0,0,0,0], [0,0,1,-1,0,0], [0,0,0,0,1,-1]

def rotate(b):
    tmp = [[0]*5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            tmp[j][4-i] = b[i][j]
    return tmp


def bfs(b):
    global res
    q = deque()
    dist = [[[0]*5 for _ in range(5)] for _ in range(5)]
    q.append((0,0,0))

    while q:
        z, y, x = q.popleft()
        if (z, y, x) == (4, 4, 4):
            res = min(res, dist[4][4][4])
            if res == 12:
                return res
        for i in range(6):
            nz, ny, nx = z+dz[i], y+dy[i], x+dx[i]
            if not (0 <= nz < 5 and 0 <= ny < 5 and 0 <= nx < 5):
                continue
            elif b[nz][ny][nx] == 0 or dist[nz][ny][nx] != 0:
                continue
            q.append((nz, ny, nx))
            dist[nz][ny][nx] = dist[z][y][x]+1


def dfs(d):
    global b
    if d == 5:
        if b[4][4][4]:
            bfs(b)
        return
    
    for _ in range(4):
        if b[0][0][0]:
            dfs(d+1)
        b[d] = rotate(b[d])


def solve():
    for d in permutations(range(0, 5)):
        for i in range(5):
            b[d[i]] = board[i]
        dfs(0)


board = [[list(map(int, input().split())) for _ in range(5)] for _ in range(5)]
b = [[[0]*5 for _ in range(5)] for _ in range(5)]

res = INF
solve()

print(res if res != INF else -1)
