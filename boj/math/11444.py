import sys
input = lambda: sys.stdin.readline().rstrip()

def mul(a, b):
    n = len(a)
    z = [[0]*n for _ in range(n)]
    
    for row in range(n):
        for col in range(n):
            e = 0
            for i in range(n):
                e += a[row][i] * b[i][col]
            z[row][col] = e % p
    return z

def square(a, k):
    if k == 1:
        for x in range(len(a)):
            for y in range(len(a)):
                a[x][y] %= p
        return a
    else:
        tmp = square(a, k//2)
        if k%2 == 0:
            return mul(tmp, tmp)
        else:
            return mul(mul(tmp, tmp), a)


n = int(input())
p = 1000000007

fib_matrix = [[1,1],[1,0]]
print(square(fib_matrix, n)[0][1])
