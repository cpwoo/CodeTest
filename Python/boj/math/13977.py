import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007
N = 4_000_001
factorial = [1]*N
for i in range(1, N):
    factorial[i] = (factorial[i-1]*i)%MOD

for _ in range(int(input())):
    n, k = map(int, input().split())

    A = factorial[n]
    B = (factorial[k]*factorial[n-k])%MOD

    # 페르마의 소정리
    B2 = 1
    expo = MOD-2
    while expo:
        if expo%2: B2 = (B*B2)%MOD

        B = (B*B)%MOD
        expo //= 2
    
    res = (A*B2)%MOD
    print(res)
