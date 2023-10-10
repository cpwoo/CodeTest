import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_000

def mul(a, b):
    ret = [[0,0],[0,0]]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                ret[i][j] += a[i][k]*b[k][j]%MOD
            ret[i][j] %= MOD
    return ret

def power(a, n):
    ret = [[1,0],[0,1]]
    while n:
        if n&1:
            ret = mul(ret, a)
        a = mul(a, a)
        n >>= 1    
    return ret


n, m = map(int, input().split())
mat = [[1,1],[1,0]]
a = power(mat, n+1)
b = power(mat, m+2)

print((b[0][1]%MOD - a[0][1]%MOD + MOD)%MOD)
