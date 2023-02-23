import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dijkstra():
    q = []
    heappush(q, [graph[0][0], 0, 0])
    dp[0][0] = 0

    while q:
        cost, x, y = heappop(q)

        if (x, y) == (n-1, n-1):
            print(f'Problem {count}: {dp[x][y]}')
            break

        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx < n) and (0 <= ny < n):
                new_cost = cost + graph[nx][ny]
                if new_cost < dp[nx][ny]:
                    dp[nx][ny] = new_cost
                    heappush(q, [new_cost, nx, ny])
    

count = 1
while True:
    n = int(input())
    if n == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(n)]
    dp = [[int(1e9)]*n for _ in range(n)]

    dijkstra()
    count += 1
