import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

n = int(input())
q = sorted([list(map(int, input().split())) for _ in range(n)])

room = []
heappush(room, q[0][1])

for i in range(1, n):
    if q[i][0] < room[0]: # 현재 끝나는 시간보다 다음 시작하는 시간이 빠르면
        heappush(room, q[i][1]) # 새로운 방 파고
    else: # 아니면
        heappop(room) # 새로운 강의로 시간 변경을 위해 pop 후 새 시간 push
        heappush(room, q[i][1])

print(len(room))
