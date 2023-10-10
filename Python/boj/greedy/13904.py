import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
homeworks = []
answer = [0]*1001

for _ in range(n):
    d, w = map(int, input().split())
    heappush(homeworks, [-w, d, w])

while homeworks:
    tmp = heappop(homeworks)
    for i in range(tmp[1], 0, -1):
        if answer[i] == 0:
            answer[i] = tmp[2]
            break

print(sum(answer))
