import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

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


n, m = map(int, input().split())
g = gcd(n, m)
mat = [[1,1],[1,0]]
ans = power(mat, g)

print(ans[0][1])
