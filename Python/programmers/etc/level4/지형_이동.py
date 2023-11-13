from heapq import *

dx, dy = [-1,1,0,0], [0,0,-1,1]

def solution(land, height):
    N = len(land)
    visited = [[False]*N for _ in range(N)]
    q = [(0,0,0)]
    answer = 0

    while q:
        v, x, y = heappop(q)
        if visited[x][y]: continue
        visited[x][y] = True
        answer += v
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < N and 0 <= ny < N and not visited[nx][ny]):
                if abs(land[nx][ny]-land[x][y]) > height:
                    heappush(q, (abs(land[nx][ny]-land[x][y]), nx, ny))
                else:
                    heappush(q, (0, nx, ny))

    return answer


land, height = [[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]], 3
print(solution(land, height)) # 15

land, height = [[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]], 1
print(solution(land, height)) # 18
