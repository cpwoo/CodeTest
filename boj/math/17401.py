import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

def mul(a, b):
    n = len(a)
    z = [[0]*n for _ in range(n)]
    for row in range(n):
        for col in range(n):
            e = 0
            for i in range(n):
                e += a[row][i] * b[i][col]
            z[row][col] = e % MOD
    return z

def square(a, k):
    n = len(a)
    z = [[0]*n for _ in range(n)]
    for row in range(n):
        for col in range(n):
            z[row][col] = 1 if row==col else 0
    while k:
        if k%2: z = mul(z, a)
        a = mul(a, a)
        k >>= 1    
    return z


T, N, D = map(int, input().split())
arr = [[[0]*N for _ in range(N)] for _ in range(T)]

for i in range(T):
    M = int(input())
    for _ in range(M):
        x, y, z = map(int, input().split())
        arr[i][x-1][y-1] = z

# 단위 행렬 생성
ans = [[0]*N for _ in range(N)]
period = [[0]*N for _ in range(N)]
for row in range(N):
    for col in range(N):
        ans[row][col] = 1 if row==col else 0
        period[row][col] = 1 if row==col else 0

for i in range(T):
    period = mul(period, arr[i])

ans = mul(ans, square(period, D//T))

for i in range(D%T):
    ans = mul(ans, arr[i])

for row in ans:
    print(*row)
