import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

for _ in range(int(input())):
    a, b = map(int, input().split())
    while a != 1:
        c = b//a+1
        a = a*c-b
        b = b*c
        G = gcd(a,b)
        a, b = a//G, b//G
    print(b)
