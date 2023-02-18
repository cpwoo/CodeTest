import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

G, L = map(int, input().split())
div = L // G

a, b = 1, div

for i in range(1, div//2+1):
    if div % i == 0:
        c = i
        d = div//i
        
        if gcd(c, d) != 1:
            continue
        if a+b > c+d:
            a, b = c, d

print(a*G, b*G)
