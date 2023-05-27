import sys
def input(): return sys.stdin.readline().rstrip()

from bisect import *

T = int(input())

N = int(input()); A = list(map(int, input().split()))
M = int(input()); B = list(map(int, input().split()))

totA, totB = [], []

for i in range(N):
    s = A[i]
    totA.append(s)
    for j in range(i+1, N):
        s += A[j]
        totA.append(s)

for i in range(M):
    s = B[i]
    totB.append(s)
    for j in range(i+1, M):
        s += B[j]
        totB.append(s)

totA.sort(); totB.sort()

answer = 0
for i in range(len(totA)):
    left = bisect_left(totB, T-totA[i])
    right = bisect_right(totB, T-totA[i])
    answer += right-left

print(answer)
