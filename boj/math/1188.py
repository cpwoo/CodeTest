import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

n, m = map(int, input().split())
print(m - gcd(n, m))
