import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

k, n = map(int, input().split())
prime = list(map(int, input().split()))

q = []
for num in prime:
    heappush(q, num)

for i in range(n):
    num = heappop(q)
    for j in range(k):
        new_num = num * prime[j]
        heappush(q, new_num)

        if num % prime[j] == 0:
            break

print(num)
