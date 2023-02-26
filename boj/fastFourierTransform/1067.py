import sys
input = lambda: sys.stdin.readline().rstrip()

from cmath import exp, pi

# 푸리에 변환 & 역변환 구현 
# 길이가 1이면 변환의 의미가 없기 때문에 변환하지 않는다.
# 다항식을 홀짝으로 분리해서 각각 재귀적으로 돌린 다음 계산값 return
# f(w) = f_even(w^2) + w * f_odd(w^2)
# f(-w) = f_even(w^2) - w * f_odd(w^2)

def fft(arr):
    N = len(arr)
    if N == 1: return arr
    arr_even = fft(arr[0::2])
    arr_odd = fft(arr[1::2])
    w_N = [exp(2j*pi*n/N) for n in range(N//2)]
    return [arr_even[n]+w_N[n]*arr_odd[n] for n in range(N//2)] \
        + [arr_even[n]-w_N[n]*arr_odd[n] for n in range(N//2)]

def ifft(arr):
    N = len(arr)
    if N == 1: return arr
    arr_even = ifft(arr[0::2])
    arr_odd = ifft(arr[1::2])
    w_N = [exp(-2j*pi*n/N) for n in range(N//2)]
    return [arr_even[n]+w_N[n]*arr_odd[n] for n in range(N//2)] \
        + [arr_even[n]-w_N[n]*arr_odd[n] for n in range(N//2)]

# 문제 조건 : M <= 60_000, N <= 120_000, 1<<17 = 131_072
M = int(input())
N = 2*M
even = 0
for i in range(18):
    if M == 1<<i:
        even = -1
        break
    elif N < 1<<i:
        even = i
        break

A = list(map(int, input().split()))
B = list(map(int, input().split()))

if even == -1:
    A = A[:]+A[:]
    B = B[::-1]+[0]*M
    C = [0]*N

    A_fft, B_fft = fft(A), fft(B)
    for i in range(N):
        C[i] = A_fft[i]*B_fft[i]
    
    C_ifft = ifft(C)
    for i in range(N):
        C_ifft[i] = round(C_ifft[i].real/N)
    _max = max(C_ifft)
else:
    N_prime = 1<<i
    N, N_prime = N_prime, N
    A = A[:]+[0]*(N-N_prime//2)
    B = B[::-1]+[0]*(N-N_prime)+B[::-1]
    C = [0]*N

    A_fft, B_fft = fft(A), fft(B)
    for i in range(N):
        C[i] = A_fft[i]*B_fft[i]
    
    C_ifft = ifft(C)
    for i in range(N):
        C_ifft[i] = round(C_ifft[i].real/N)
    _max = max(C_ifft)

print(_max)
