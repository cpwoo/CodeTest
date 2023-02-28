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
    _max = (len(A)+len(B))-1
    n = 1
    while n <= _max:
        n <<= 1    
    A += [0]*(n-len(A))
    B += [0]*(n-len(B))

    fft(A); fft(B)
    for i in range(n):
        A[i] *= B[i]
    
    fft(A, True)
    C = [0]*n
    for i in range(n):
        C[i] = round(A[i].real)

    return C

# [-30000, 30000] 범위에서 a_i + c_j = 2*b_k 를 만족하는 (i, j, k) 개수
# 등장여부를 리스트(A, B, C)로 저장하면 구해야 하는 값은 
# B[x] * (A[y]*C[2x-y]) (0 <= x <= 60000), (0 <= y <= 2x)
# conv[x] 를 A 와 C 의 convolution 이라 하면 위 식은 B[x] * conv[2x] (0 <= x <= 60000) 으로 변환 

_max = 60001

na = int(input())
A = [False]*(_max+1)
dotA = list(map(int, input().split()))

for d in dotA:
    A[30000+d] = True

nb = int(input())
B = [False]*(_max+1)
dotB = list(map(int, input().split()))

for d in dotB:
    B[30000+d] = True

nc = int(input())
C = [False]*(_max+1)
dotC = list(map(int, input().split()))

for d in dotC:
    C[30000+d] = True

A = multiply(A, C)

ans = 0
for i in range(60000):
    if B[i]:
        ans += A[i<<1]

print(ans)
