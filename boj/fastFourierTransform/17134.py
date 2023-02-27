import sys
input = lambda: sys.stdin.readline().rstrip()

from math import pi
from cmath import *

def fft(arr, inv=False):
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
    
    m = 1
    while m < n:
        theta = (-pi/m if inv else pi/m)
        w = complex(cos(theta), sin(theta))
        for i in range(0, n, m*2):
            p = complex(1, 0)
            for j in range(m):
                tmp = arr[m+i+j]*p
                arr[m+i+j] = arr[i+j]-tmp
                arr[i+j] += tmp
                p *= w   
        m *= 2
            
    if inv:
        for i in range(n):
            arr[i] /= n
    

def multiply(A, B):
    _max = len(A)+len(B)-1
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
