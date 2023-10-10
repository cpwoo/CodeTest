import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

# 11000.py 와 동일한 문제

n = int(input())
q = sorted([list(map(int, input().split())) for _ in range(n)])

room = []
heappush(room, q[0][1])

for i in range(1, n):
    if q[i][0] < room[0]:
        heappush(room, q[i][1])
    else:
        heappop(room)
        heappush(room, q[i][1])

print(len(room))
