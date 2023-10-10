import sys
input = lambda: sys.stdin.readline().rstrip()

def is_matching(x, y, sticker, R, C):
    for i in range(x, x+R):
        for j in range(y, y+C):
            if notebook[i][j] and sticker[i-x][j-y]:
                return False
    for i in range(x, x+R):
        for j in range(y, y+C):
            if sticker[i-x][j-y]:
                notebook[i][j]=1
    return True

def find_sticker_start(sticker, R, C):
    for i in range(N-R+1):
        for j in range(M-C+1):
            if is_matching(i, j, sticker, R, C):
                return True
    return False

def turn_sticker(sticker):
    sticker = [k[::-1] for k in zip(*sticker)]
    return sticker

N, M, K = map(int, input().split())
notebook = [[0 for _ in range(M)] for _ in range(N)]

for _ in range(K):
    R, C = map(int, input().split())
    sticker = [list(map(int, input().split())) for _ in range(R)]

    for _ in range(4):
        if find_sticker_start(sticker, R, C):
            break
        else:
            sticker = turn_sticker(sticker)
            R, C = C, R

sum_sticker = 0
for i in range(N):
    sum_sticker += sum(notebook[i])
print(sum_sticker)
