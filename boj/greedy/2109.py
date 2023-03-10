import sys
def input(): return sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
lectures = []

for _ in range(n):
    w, d = map(int, input().split())
    lectures.append([w, d])

lectures.sort(key=lambda x: x[1])
q = []

for pay, day in lectures:
    heappush(q, pay)

    if day < len(q):
        heappop(q)

print(sum(q))
