import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dijkstra():
    q = []
    heappush(q, [0, 0, 0])
    visited[0][0] = 1
    while q:
        a, x, y = heappop(q)
        if (x, y) == (N-1, N-1):
            return a
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < N) and (0 <= ny < N) and not visited[nx][ny]:
                visited[nx][ny] = 1
                if arr[nx][ny] == 0:
                    heappush(q, [a+1, nx, ny])
                else:
                    heappush(q, [a, nx, ny])


N = int(input())
arr = [list(map(int, input())) for _ in range(N)]
visited = [[0]*N for _ in range(N)]

print(dijkstra())
