import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

# 방향, 상어의 위치와 사이즈
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]
x, y, size = 0, 0, 2
            
# 사냥 시작
def game(x, y, size):
    # 거리와 방문 여부 저장소
    distance = [[0]*n for _ in range(n)]
    visited = [[False]*n for _ in range(n)]
    
    # 상어가 있는 위치 방문 처리
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    tmp = []
    
    # bfs 실행
    while q:
        tx, ty = q.popleft()
        for i in range(4):
            nx, ny = tx+dx[i], ty+dy[i]
            if (0 <= nx < n) and (0 <= ny < n) and not visited[nx][ny]:
                if graph[nx][ny] <= size:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    distance[nx][ny] = distance[tx][ty] + 1
                    if graph[nx][ny] < size and graph[nx][ny] != 0:
                        tmp.append((nx, ny, distance[nx][ny]))                        
    # 어떻게 정렬할 것인가?
    return sorted(tmp, key=lambda t : (-t[2], -t[0], -t[1]))


n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

# 상어 찾기
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            x, y = i, j

cnt = 0
result = 0
while True:
    shark = game(x, y, size)
    # 사냥을 할 수 없으면 종료 (엄마 상어 호출)
    if len(shark) == 0:
        break
    
    # 사냥감을 꺼내고
    nx, ny, distance = shark.pop()
    
    # 상어가 사냥감으로 이동
    result += distance
    graph[x][y], graph[nx][ny] = 0, 0
    
    # 이동했으면 상어 위치 갱신
    x, y = nx, ny
    
    # 사냥 결과 반영
    cnt += 1
    if cnt == size:
        size += 1
        cnt = 0

print(result)
