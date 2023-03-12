import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]
direction = ['L', 'R', 'U', 'D']

def move(x, y, idx):
    global answer
    if group[x][y] != -1:
        if group[x][y] == idx:
            answer += 1
        return
    
    group[x][y] = idx
    i = direction.index(table[x][y])
    move(x+dx[i], y+dy[i], idx)


n, m = map(int, input().split())
table = [list(input()) for _ in range(n)]

group = [[-1]*m for _ in range(n)]

idx = 0
answer = 0

for i in range(n):
    for j in range(m):
        move(i, j, idx)
        idx += 1

print(answer)
