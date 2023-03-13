import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

N, K = map(int, input().split())

jew = sorted([list(map(int, input().split())) for _ in range(N)])
bags = sorted([int(input()) for _ in range(K)])

answer = 0
tmp_jew = []
for bag in bags:
    while jew and bag >= jew[0][0]:
        heappush(tmp_jew, -heappop(jew)[1])
    if tmp_jew:
        answer -= heappop(tmp_jew)

print(answer)
