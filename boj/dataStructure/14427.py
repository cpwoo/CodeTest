import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

N = int(input())
A = [0] + list(map(int, input().split()))
M = int(input())

q = []
for i in range(1, N+1):
    heappush(q, (A[i], i))

for _ in range(M):
    cmd = list(map(int, input().split()))
    if cmd[0] == 1:
        a, b = cmd[1], cmd[2]
        A[a] = b
        heappush(q, (b, a))
    else:
        while A[q[0][1]] != q[0][0]:
            heappop(q)
        print(q[0][1])
