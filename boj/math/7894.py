import sys
input = lambda: sys.stdin.readline().rstrip()

from math import log10

for _ in range(int(input())):
    n = int(input())
    ret = 0
    for i in range(1, n+1):
        ret += log10(i)
    print(int(ret)+1)
