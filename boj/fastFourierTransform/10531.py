import sys
input = lambda: sys.stdin.readline().rstrip()

from cmath import exp, pi
from math import ceil, log2

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


M = 1<<ceil(log2(400_002))
arr = [0]*M

arr[0] = 1
for _ in range(int(input())):
    arr[int(input())] = 1

# 2타 => 자기 자신 푸리에 변환해서 곱해주고 역변환
arr = fft(arr)
for i in range(M):
    arr[i] *= arr[i]
arr = ifft(arr)

cnt = 0
for _ in range(int(input())):
    target = int(input())
    if round(arr[target].real):
        cnt += 1

print(cnt)
