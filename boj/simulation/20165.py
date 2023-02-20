import sys
input = lambda: sys.stdin.readline().rstrip()

def attack(sr, sc, sd, length):
    global temp
    if board[sr][sc]:
        board[sr][sc] = 0
        temp += 1
    for _ in range(length-1):
        sr += direction[sd][0]
        sc += direction[sd][1]
        if not (0 <= sr < n and 0 <= sc < m):
            continue
        attack(sr, sc, sd, board[sr][sc])

n, m, r = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
_board = [row[:] for row in board]
direction = {'E':(0,1), 'W':(0,-1), 'S':(1,0), 'N':(-1,0)}
total = 0

for _ in range(r):
    ar, ac, ad = input().split()
    dr, dc = map(int, input().split())
    
    # 1부터 시작 -> 0부터 시작
    ar, ac = int(ar)-1, int(ac)-1
    dr, dc = dr-1, dc-1
    
    # 공격
    temp = 0
    if board[ar][ac]:
        attack(ar, ac, ad, board[ar][ac])
    
    # 수비
    board[dr][dc] = _board[dr][dc]
    total += temp
    
print(total)
for r in range(n):
    for c in range(m):
        if board[r][c]:
            board[r][c] = 'S'
        else:
            board[r][c] = 'F'
    print(*board[r])
