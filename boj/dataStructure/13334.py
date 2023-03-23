import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
info = [list(map(int, input().split())) for _ in range(n)]
d = int(input())

roads = []
for road in info:
    house, office = road
    if abs(house-office) <= d:
        road = sorted(road)
        roads.append(road)
roads.sort(key=lambda x:x[1])

answer = 0
q = []
for road in roads:
    if not q:
        heappush(q, road)
    else:
        while q[0][0] < road[1]-d:
            heappop(q)
            if not q:
                break
        heappush(q, road)
    answer = max(answer, len(q))

print(answer)
