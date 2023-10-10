import sys
input = lambda: sys.stdin.readline().rstrip()

from math import log10
from itertools import count

# count(start=0, step=1) 
# 0부터 시작해서 1씩 증가하는 loop (while문과 유사)

n = input()
logN = len(n)-1+log10(int(n[0]))

s = 0
for i in count(1):
    s += log10(i)
    if s >= logN:
        break

print(i)
