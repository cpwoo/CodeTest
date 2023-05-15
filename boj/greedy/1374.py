import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
q = []
for _ in range(n):
    num, s, e = map(int, input().split())
    heappush(q, (s, e))

room = [0]
while q:
    s, e = heappop(q)
    if s >= room[0]:
        heappop(room)
        heappush(room, e)
    else:
        heappush(room, e)

print(len(room))
