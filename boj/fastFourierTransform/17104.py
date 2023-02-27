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
    

def multiply(A):
    _max = (len(A)<<1)-1
    n = 1
    while n <= _max:
        n <<= 1    
    A += [0]*(n-len(A))

    fft(A)
    for i in range(n):
        A[i] *= A[i]
    
    fft(A, True)
    C = [0]*n
    for i in range(n):
        C[i] = round(A[i].real)

    return C


_max = 1_000_000
v = [1]*(_max+1)
v[0] = v[1] = 0
for i in range(2, 1_001):
    if v[i] == 1:
        for j in range(i<<1, _max, i):
            v[j] = 0

w = [0]*(_max+1)
for i in range(1, _max>>1):
    w[i<<1] = v[i]

v = multiply(v)

for _ in range(int(input())):
    x = int(input())
    print((v[x]+w[x])>>1)
