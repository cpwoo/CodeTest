import sys
input = lambda: sys.stdin.readline().rstrip()

from decimal import *

D = Decimal

getcontext().prec = 100

p = 20

def f(x):
    return a*x*x*x+b*x*x+c*x+d

def search(s, e):
    lim = D('1.0e-20')
    while e-s > lim:
        m = (s+e)/2
        if f(m) * f(s) > 0:
            s = m
        else:
            e = m
    return s
    
def solve():
    alpha, beta = D('-1e+7'), D('1e+7')
    if b*b < 3*a*c:
        ret = [search(alpha, beta)]
    else:
        x1 = (-b-(b*b-3*a*c)**D('0.5'))/(3*a)
        x2 = (-b+(b*b-3*a*c)**D('0.5'))/(3*a)
        if x1 > x2:
            x1, x2 = x2, x1
        
        if round(f(x1)*f(x2), p) > 0:
            ret = [search(alpha, beta)]
        elif round(f(x1), p) == 0 or round(f(x2), p) == 0:
            if round(f(x1), p) == 0:
                if round(x1, p) == round(x2, p):
                    ret = [x1]
                else:
                    ret = [x1, search(x2, beta)]
            else:
                ret = [search(alpha, x1), x2]
        else:
            ret = [search(alpha, x1), search(x1, x2), search(x2, beta)]
    
    return ret


for _ in range(int(input())):
    a, b, c, d = map(D, input().split())
    ret = solve()
    ret = ["{:.20f}".format(r) for r in ret]
    print(*ret)
