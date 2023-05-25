import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

def mul(a, b):
    ret = [[0]*size for _ in range(size)]
    for i in range(size):
        for j in range(size):
            for k in range(size):
                ret[i][j] += a[i][k]*b[k][j]%MOD
            ret[i][j] %= MOD
    return ret

def power(a, n):
    ret = [[0]*size for _ in range(size)]
    for i in range(size):
        ret[i][i] = 1
    while n:
        if n&1:
            ret = mul(ret, a)
        a = mul(a, a)
        n >>= 1    
    return ret


k, n = map(int, input().split())
size = k+2

mat = [[0]*size for _ in range(size)]
for i in range(size):
    for j in range(i+1):
        mat[i][j] = 1

mat = power(mat, n)
print(mat[-1][0])
