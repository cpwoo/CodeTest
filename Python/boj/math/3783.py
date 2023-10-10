import sys
input = lambda: sys.stdin.readline().rstrip()

from decimal import *

D = Decimal

getcontext().prec=1000

for _ in range(int(input())):
    n = D(input() + '.0000000000')
    p = D('1')/D('3')
    n = D(n**p)
    n = round(n, 500)
    n = D(n).quantize(D('.0000000001'),rounding=ROUND_DOWN)
    print(n)
