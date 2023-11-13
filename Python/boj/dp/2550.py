import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

n = int(input())
L = list(map(int, input().split()))
R = list(map(int, input().split()))

d = [0]*(n+1)
for i, v in enumerate(R):
    d[v] = i+1

LIS = []
indexs = []

for v in L:
    now = d[v]
    if not LIS or LIS[-1] < now:
        indexs.append(len(LIS))
        LIS.append(now)
    else:
        cur = bisect_left(LIS, now)
        if len(LIS) == cur:
            LIS.append(now)
        else:
            LIS[cur] = now
        indexs.append(cur)

print(len(LIS))

answer = []
position = max(indexs)
for v in indexs[::-1]:
    n -= 1
    if position == v:
        answer.append(L[n])
        position -= 1

print(*sorted(answer))
