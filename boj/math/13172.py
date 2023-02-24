import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

X = 1_000_000_007

def getExpectedValue(n, s):
    return s * getSquaredNumber(n, X-2) % X

def getSquaredNumber(num, exp):
    if exp == 1:
        return num
    
    if exp%2 == 0:
        half = getSquaredNumber(num, exp//2)
        return half * half % X
    else:
        return num * getSquaredNumber(num, exp-1) % X


_sum = 0
for _ in range(int(input())):
    n, s = map(int, input().split())
    g = gcd(n, s)
    n //= g
    s //= g

    _sum += getExpectedValue(n, s)
    _sum %= X

print(_sum)
