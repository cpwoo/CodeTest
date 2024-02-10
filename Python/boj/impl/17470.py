import sys
input = lambda : sys.stdin.readline().rstrip()

n, m, r = map(int, input().split())
table = [list(map(int, input().split())) for _ in range(n)]

# 어느 4분면을 가리키는가 check
four = [[0, 1], [2, 3]]

vert, hori = False, False
rot = 0

cmd = list(map(int, input().split()))

# 실제로 돌리지 않고 4분면을 가리키는 pointer만 변화
for c in cmd:

    if c == 1:
        if rot&1:
            hori = not hori
        else:
            vert = not vert
        
        four[0][0], four[1][0] = four[1][0], four[0][0]
        four[0][1], four[1][1] = four[1][1], four[0][1]
    
    elif c == 2:
        if rot&1:
            vert = not vert
        else:
            hori = not hori
        
        four[0][0], four[0][1] = four[0][1], four[0][0]
        four[1][0], four[1][1] = four[1][1], four[1][0]
    
    elif c == 3:
        rot = (rot+1)%4
        four[0][0], four[1][0], four[1][1], four[0][1] = four[1][0], four[1][1], four[0][1], four[0][0]

    elif c == 4:
        rot = (rot-1)%4
        four[0][0], four[0][1], four[1][1], four[1][0] = four[0][1], four[1][1], four[1][0], four[0][0]
    
    elif c == 5:
        four[0][0], four[1][0], four[1][1], four[0][1] = four[1][0], four[1][1], four[0][1], four[0][0]
    
    elif c == 6:
        four[0][0], four[0][1], four[1][1], four[1][0] = four[0][1], four[1][1], four[1][0], four[0][0]


halfN, halfM = n//2, m//2

if hori:
    for x in range(n):
        table[x][:halfM] = table[x][:halfM][::-1]
        table[x][halfM:] = table[x][halfM:][::-1]

if vert:
    table[:halfN] = table[:halfN][::-1]
    table[halfN:] = table[halfN:][::-1]

# 4분면으로 분할하여 테이블 입력
quadTable = [[[0]*halfM for _ in range(halfN)] for _ in range(4)]
for x in range(halfN):
    for y in range(halfM):
        quadTable[0][x][y] = table[x][y]
        quadTable[1][x][y] = table[x][y+halfM]
        quadTable[2][x][y] = table[x+halfN][y]
        quadTable[3][x][y] = table[x+halfN][y+halfM]

# 회전 수에 따라 판 돌리기
# 이때 가로 세로 Size가 서로 바뀔 수 있으므로 이에 유의하여 작성
_max = max(halfN, halfM)
ret = [[[0]*_max for _ in range(_max)] for _ in range(4)]

if rot == 0:
    for x in range(halfN):
        for y in range(halfM):
            for k in range(4):
                ret[k][x][y] = quadTable[k][x][y]

elif rot == 1:
    for x in range(halfN):
        for y in range(halfM):
            for k in range(4):
                ret[k][y][halfN-1-x] = quadTable[k][x][y]
    n, m = m, n
    halfN, halfM = halfM, halfN

elif rot == 2:
    for x in range(halfN):
        for y in range(halfM):
            for k in range(4):
                ret[k][halfN-1-x][halfM-1-y] = quadTable[k][x][y]

elif rot == 3:
    for x in range(halfN):
        for y in range(halfM):
            for k in range(4):
                ret[k][halfM-1-y][x] = quadTable[k][x][y]
    n, m = m, n
    halfN, halfM = halfM, halfN


# 출력
for x in range(halfN):
    arr = []
    for y in range(halfM):
        arr.append(ret[four[0][0]][x][y])
    for y in range(halfM):
        arr.append(ret[four[0][1]][x][y])
    print(*arr)

for x in range(halfN):
    arr = []
    for y in range(halfM):
        arr.append(ret[four[1][0]][x][y])
    for y in range(halfM):
        arr.append(ret[four[1][1]][x][y])
    print(*arr)
