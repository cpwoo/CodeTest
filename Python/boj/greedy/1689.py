import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
lines = sorted([list(map(int, input().split())) for _ in range(n)])

q = []
heappush(q, lines[0][1])

ans = 1
for line in lines[1:]:
    while q and q[0] <= line[0]:
        heappop(q)
    heappush(q, line[1])
    ans = max(ans, len(q))

print(ans)
