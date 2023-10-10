import sys
input = lambda: sys.stdin.readline().rstrip()

from math import factorial

NUM = 1_000_000_000

N, K = map(int, input().split())
A = N+K-1
answer = factorial(A) // (factorial(K-1) * factorial(A-K+1))
print(answer%NUM)
