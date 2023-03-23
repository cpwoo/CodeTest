import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

n = int(input())
cases = list(map(int, input().split()))
lis = [0]

for case in cases:
    if lis[-1] < case:
        lis.append(case)
    else:
        lis[bisect_left(lis, case)] = case

print(len(lis)-1)
