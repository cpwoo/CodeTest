import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)])

q = []

for a in arr:
    heappush(q, a[1])
    if a[0] < len(q):
        heappop(q)

print(sum(q))
