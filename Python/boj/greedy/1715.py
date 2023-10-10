import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
arr = [int(input()) for _ in range(n)]
heapify(arr)

ans = 0
while len(arr) > 1:
    p = heappop(arr)
    q = heappop(arr)
    ans += p+q
    heappush(arr, (p+q))

print(ans)
