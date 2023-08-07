import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

a, b = map(int, input().split())
print(int(b*log10(a))+1)
