dy, dx = (1, 0, -1, 0), (0, -1, 0, 1)

def solution(grid):
    answer = []
    N, M = len(grid), len(grid[0])
    visited = [[[False]*4 for _ in range(M)] for _ in range(N)]
    for y in range(N):
        for x in range(M):
            for d in range(4):
                if visited[y][x][d]: continue
                cnt = 0
                ny, nx = y, x
                while not visited[ny][nx][d]:
                    visited[ny][nx][d] = True
                    cnt += 1
                    if grid[ny][nx] == "S":
                        pass
                    elif grid[ny][nx] == "L":
                        d = (d-1)%4
                    elif grid[ny][nx] == "R":
                        d = (d+1)%4
                    ny, nx = (ny+dy[d])%N, (nx+dx[d])%M
                answer.append(cnt)
    return sorted(answer)


grid = ["SL","LR"]
print(solution(grid)) # [16]

grid = ["S"]
print(solution(grid)) # [1,1,1,1]

grid = ["R","R"]
print(solution(grid)) # [4,4]
