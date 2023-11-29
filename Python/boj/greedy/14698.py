import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

MOD = 1_000_000_007

for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))

    q = []
    for a in arr:
        heappush(q, a)
    
    ret = 1
    while len(q) >= 2:
        a, b = heappop(q), heappop(q)
        ret = (ret*a*b)%MOD
        heappush(q, a*b)
    
    print(ret)
