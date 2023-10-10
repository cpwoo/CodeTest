import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

MOD = 1_000_003

# 행렬 연산
def mul(a, b):
    n = len(a)
    ret = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                ret[i][j] += a[i][k]*b[k][j]
            ret[i][j] %= MOD
    return ret


n, s, e, t = map(int, input().split())
s -= 1; e -= 1

matrix = [[0]*(5*n+1) for _ in range(5*n+1)]

for i in range(n):
    st = input()
    for j in range(n):
        cur = int(st[j])
        if cur>0: matrix[5*i+cur-1][5*j] = 1
    
    for j in range(4):
        matrix[5*i+j][5*i+j+1] = 1


if t>0:
    ans = deepcopy(matrix)
    t -= 1

while t>0:
    if t&1: ans = mul(ans, matrix)

    matrix = mul(matrix, matrix)
    t >>= 1

print(ans[s*5][e*5])
