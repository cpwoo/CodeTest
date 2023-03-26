import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def f(x):
    return a*exp(-(x*x))+b*sqrt(x)

def g(x):
    fx = f(x)
    return fx*fx*pi

def volume():
    ans = 0.0
    for i in range(numOfInterval):
        p, q = interval*i, interval*(i+1)
        ans += (interval/6)*(g(p)+4*g((p+q)/2)+g(q))
    return ans


v, n = map(float, input().split())
arr = []
for _ in range(int(n)):
    a, b, h = map(float, input().split())
    numOfInterval = ceil(h/0.00005)
    interval = h/numOfInterval
    arr.append(abs(v-volume()))

print(arr.index(min(arr)))
