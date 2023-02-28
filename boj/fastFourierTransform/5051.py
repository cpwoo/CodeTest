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


n = int(input())
a = [0]*n

for i in range(1, n):
    a[i*i%n] += 1

b = a[:]
c = multiply(b)

ans = 0
for i in range(n):
    ans += a[i]*(c[i]+c[i+n]+a[i*2%n])

print(ans//2)
