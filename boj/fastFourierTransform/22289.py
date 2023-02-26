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


a, b = input().split()
n = len(a)+len(b)-1
a = list(map(int, list(a)))
b = list(map(int, list(b)))

if a[0] == 0 or b[0] == 0:
    print(0)
    exit()

c = multiply(a, b)[:n]

result = [0]*(n+1)
for i in range(n, 0, -1):
    result[i] += c[i-1]%10
    result[i-1] += c[i-1]//10
    result[i-1] += result[i]//10
    result[i] %= 10

flag = True
for i in result:
    if flag and i == 0:
        continue
    else:
        flag = False
    print(i, end='')
