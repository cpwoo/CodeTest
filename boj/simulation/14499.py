import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [0, 0, -1, 1], [1, -1, 0, 0]

def turn(dir):
    a, b, c, d, e, f = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]
    
    if dir == 1:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = d, b, a, f, e, c
    elif dir == 2:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = c, b, f, a, e, d
    elif dir == 3:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = e, a, c, d, f, b
    else:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = b, f, c, d, a, e


n, m, x, y, k = map(int, input().split())
dice = [0]*6
board = [list(map(int, input().split())) for _ in range(n)]
command = list(map(int, input().split()))

nx, ny = x, y
for c in command:
    nx += dx[c-1]
    ny += dy[c-1]

    if nx < 0 or nx >= n or ny < 0 or ny >= m:
        nx -= dx[c-1]
        ny -= dy[c-1]
        continue

    turn(c)
    if board[nx][ny] == 0:
        board[nx][ny] = dice[-1]
    else:
        dice[-1] = board[nx][ny]
        board[nx][ny] = 0
    
    print(dice[0])
