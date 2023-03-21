import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

try:
    while input():
        q = []
        for i in map(int, input().split()):
            s = bisect_left(q, i)
            if s != len(q):
                q[s] = i
            else:
                q.append(i)
        print(len(q))
except:
    exit()
