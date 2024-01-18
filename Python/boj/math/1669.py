import sys
input = lambda: sys.stdin.readline().rstrip()

X, Y = map(int, input().split())
D = Y-X

cnt, move, d = 0, 1, 0

while d < D:
    cnt += 1
    d += move
    if cnt%2 == 0:
        move += 1

print(cnt)
