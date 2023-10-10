import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    heapify(arr) 
    ans = 0
    while len(arr) > 1:
        p = heappop(arr)
        q = heappop(arr)
        ans += p + q
        heappush(arr, (p+q))
    
    print(ans)
