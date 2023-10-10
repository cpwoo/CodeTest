import sys
input = lambda: sys.stdin.readline().rstrip()

N, B = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

def mul(u, v):
    z = [[0]*N for _ in range(N)]
    for row in range(N):
        for col in range(N):
            e = 0
            for i in range(N):
                e += u[row][i] * v[i][col]
            z[row][col] = e % 1000
    return z

def square(a, b):
    if b == 1:
        for x in range(len(a)):
            for y in range(len(a)):
                a[x][y] %= 1000
        return a
    else:
        tmp = square(a, b//2)
        if b%2 == 0:
            return mul(tmp, tmp)
        else:
            return mul(mul(tmp, tmp), a)

C = square(A, B)
for row in C:
    print(*row)
