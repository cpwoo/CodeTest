import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
minq, maxq = [], []
level = {}
for _ in range(n):
    P, L = map(int, input().split())
    heappush(minq, (L, P))
    heappush(maxq, (-L, -P))
    if not level.get(P):
        level[P] = 0
    level[P] = L

m = int(input())
for _ in range(m):
    c, *args = input().split()
    if c == 'add':
        P, L = map(int, args)
        heappush(minq, (L, P))
        heappush(maxq, (-L, -P))
        if not level.get(P):
            level[P] = 0
        level[P] = L
    elif c == 'solved':
        P = int(args[0])
        level[P] = 0
    elif c == 'recommend':
        x = args[0]
        if x == '1':
            while maxq and level[-maxq[0][1]] != -maxq[0][0]:
                heappop(maxq)
            print(-maxq[0][1])
        elif x == '-1':
            while minq and level[minq[0][1]] != minq[0][0]:
                heappop(minq)
            print(minq[0][1])
