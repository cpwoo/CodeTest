import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

q = []
for _ in range(int(input())):
    a, b = map(int, input().split())
    heappush(q, [a, b])

L, P = map(int, input().split())

cnt = 0
heap = []
while P < L:
    while q and q[0][0] <= P:
        a, b = heappop(q)
        heappush(heap, [-b, a])
    if not heap:
        cnt = -1
        break
    b, a = heappop(heap)
    P += -b
    cnt += 1

print(cnt)
