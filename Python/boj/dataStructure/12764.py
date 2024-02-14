import sys
input = lambda : sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)])

ret = [0]*n
ret[0] = 1

q = []
heappush(q, (arr[0][1], 0))

seat = list(range(1, n))
heapify(seat)

for a in arr[1:]:
    s, e = a

    if q[0][0] > s:
        pos = heappop(seat)
        ret[pos] += 1
        heappush(q, (e, pos))
    else:
        while True:
            prev_e, prev_pos = heappop(q)
            if q and q[0][0] <= s:
                heappush(seat, prev_pos)
            else:
                pos = heappushpop(seat, prev_pos)
                heappush(q, (e, pos))
                ret[pos] += 1
                break

idx = n-ret.count(0)
print(idx)
print(*ret[:idx])
