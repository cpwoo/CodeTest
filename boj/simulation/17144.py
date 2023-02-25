import sys
input = lambda: sys.stdin.readline().rstrip()

def spread():
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]    
    tmp_arr = [[0]*C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if arr[i][j] != 0 and arr[i][j] != -1:
                tmp = 0
                for k in range(4):
                    ni, nj = i+dx[k], j+dy[k]
                    if (0 <= ni < R) and (0 <= nj < C) and arr[ni][nj] != -1:
                        tmp_arr[ni][nj] += arr[i][j] // 5
                        tmp += arr[i][j] // 5
                arr[i][j] -= tmp                
    for i in range(R):
        for j in range(C):
            arr[i][j] += tmp_arr[i][j]

def air_up():
    dx, dy = [0, -1, 0, 1], [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = up, 1
    while True:
        nx, ny = x+dx[direct], y+dy[direct]
        if (x, y) == (up, 0):
            break
        if not (0 <= nx < R and 0 <= ny < C):
            direct += 1
            continue
        arr[x][y], before = before, arr[x][y]
        x, y = nx, ny
        
def air_down():
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
    direct = 0
    before = 0
    x, y = down, 1
    while True:
        nx, ny = x+dx[direct], y+dy[direct]
        if (x, y) == (down, 0):
            break
        if not (0 <= nx < R and 0 <= ny < C):
            direct += 1
            continue
        arr[x][y], before = before, arr[x][y]
        x, y = nx, ny


R, C, T = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(R)]

up, down = -1, -1

for i in range(R):
    if arr[i][0] == -1:
        up = i
        down = i+1
        break

for _ in range(T):
    spread()
    air_up()
    air_down()
    
answer = 0
for i in range(R):
    for j in range(C):
        if arr[i][j] > 0:
            answer += arr[i][j]

print(answer)
