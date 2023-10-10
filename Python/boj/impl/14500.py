import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def block_T(x, y):
    result = board[x][y]
    wings = 4
    MIN = int(1e9)
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if wings == 2:
            return 0
        if not (0 <= nx < N and 0 <= ny < M):
            wings -= 1
            continue
        result += board[nx][ny]
        MIN = min(MIN, board[nx][ny])
    if wings == 4:
        result -= MIN
    return result

def dfs(x,y,val,depth):
    global answer
    if depth == 4:
        answer = max(answer, val)
        return
    
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if (0 <= nx <N) and (0 <= ny <M):
            if check[nx][ny]:
                check[nx][ny] = False
                dfs(nx,ny,val+board[nx][ny],depth+1)
                check[nx][ny] = True


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
check = [[True]*M for _ in range(N)]

answer = 0
for i in range(N):
    for j in range(M):
        check[i][j] = False
        dfs(i,j,board[i][j],1)
        check[i][j] = True
        tmp = block_T(i,j)
        answer = max(answer, tmp)

print(answer)
