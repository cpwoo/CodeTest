import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

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


n = int(input())
mat = [[1,1],[1,0]]
mat = power(mat, n)

print(mat[0][0]*mat[0][1]%MOD)
