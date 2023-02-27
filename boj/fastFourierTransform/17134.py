import sys
input = lambda: sys.stdin.readline().rstrip()

p = 469762049

def fft(arr, invert=False):
    j = 0
    n = len(arr)
    for i in range(1, n):
        bit = n>>1
        while j >= bit:
            j -= bit
            bit >>= 1
        j += bit
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
    m = 2
    while m <= n:
        u = pow(3, p//m, p)
        if invert:
            u = pow(u, p-2, p)
        for i in range(0, n, m):
            w = 1
            for k in range(i, i+m//2):
                tmp = arr[k+m//2]*w
                arr[k+m//2] = (arr[k]-tmp)%p
                arr[k] = (arr[k]+tmp)%p
                w = (w*u)%p
        m *= 2
    if invert:
        invertedN = p-(p-1)//n
        for i in range(n):
            arr[i] = (arr[i]*invertedN)%p


def multiply(A, B):
    _max = max(len(A), len(B))
    N = 1
    while N < _max:
        N <<= 1
    N <<= 1
    A += [0]*(N-len(A))
    B += [0]*(N-len(B))
    C = [0]*N

    fft(A); fft(B)
    C = [(i*j)%p for i,j in zip(A, B)]

    fft(C, invert=True)
    return C


_max = 1_000_000
v = [1]*(_max+1)
v[0] = v[1] = 0
for i in range(2, _max):
    if v[i] == 1:
        for j in range(i*2, _max, i):
            v[j] = 0

w = [0]*(_max+1)
for i in range(2, _max//2):
    w[i*2] = v[i]

w = multiply(v, w)

for _ in range(int(input())):
    print(w[int(input())])
