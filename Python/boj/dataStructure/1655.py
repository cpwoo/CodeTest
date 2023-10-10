import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
left_heap = []
right_heap = []
answer = []

for _ in range(n):
    x = int(input())
    if len(left_heap) == len(right_heap):
        heappush(left_heap, (-x, x))
    else:
        heappush(right_heap, (x, x))
        
    if right_heap and left_heap[0][1] > right_heap[0][1]:
        tmp_min = heappop(right_heap)[1]
        tmp_max = heappop(left_heap)[1]
        heappush(left_heap, (-tmp_min, tmp_min))
        heappush(right_heap, (tmp_max, tmp_max))
    answer.append(left_heap[0][1])

print(*answer, sep='\n')
