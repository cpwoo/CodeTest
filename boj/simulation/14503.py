import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]

N, M = map(int, input().split())
R, C, D = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[False]*M for _ in range(N)]

visited[R][C] = True
cnt = 1

while True:
    flag = 0
    for _ in range(4):
        nx, ny = R+dx[(D+3)%4], C+dy[(D+3)%4]
        D = (D+3)%4        
        if (0 <= nx < N) and (0 <= ny < M) and not visited[nx][ny] and graph[nx][ny] == 0:
            visited[nx][ny] = True
            cnt += 1
            R, C = nx, ny
            flag = 1
            break
    if flag == 0:
        if graph[R-dx[D]][C-dy[D]] == 1:
            print(cnt)
            break
        else:
            R, C = R-dx[D], C-dy[D]
