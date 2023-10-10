import sys
input = lambda: sys.stdin.readline().rstrip()

def shoot(y, position, s_board):
    for d in range(1, D+1):
        for left in range(d, -1, -1):
            height = d - left
            if height > 0 and (0 <= y-height < N) and (0 <= position-left < M) and s_board[y-height][position-left] == 1:
                return (y-height, position-left)
        for right in range(1, d+1, 1):
            height = d - right
            if height > 0 and (0 <= y-height < N) and (0 <= position+right < M) and s_board[y-height][position+right] == 1:
                return (y-height, position+right)        
    return None

def simulation(positions):
    s_board = [line[:] for line in board]
    killed_amount = 0
    for y in range(N, 0, -1):
        killed = []
        for position in positions:
            killed_enemy = shoot(y, position, s_board)
            if killed_enemy:
                killed.append(killed_enemy)
        for killed_enemy in killed:
            if s_board[killed_enemy[0]][killed_enemy[1]] == 1:
                s_board[killed_enemy[0]][killed_enemy[1]] = 0
                killed_amount += 1
    return killed_amount


N, M, D = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

max_v = 0
for i in range(M):
    for j in range(i+1, M):
        for k in range(j+1, M):
            max_v = max(max_v, simulation((i,j,k)))
            
print(max_v)
