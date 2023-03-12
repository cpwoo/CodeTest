import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def f(x):
    return a*x+b*sin(x)-c

a, b, c = map(int, input().split())
l, r = 0, 10**6
x = (l+r)/2

while abs(r-l) >= 10**(-9):
    if f(x) > 0: r = x
    else: l = x
    x = (l+r)/2

print(x)
