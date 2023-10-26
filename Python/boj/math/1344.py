import sys
input = lambda: sys.stdin.readline().rstrip()

prime = [2,3,5,7,11,13,17]
combi = [153,816,8568,31824,31824,8568,18]

a, b = int(input()), int(input())
pa, pb = a/100, b/100

sa, sb = 0, 0
for i in range(7):
    sa += combi[i]*pow(pa, prime[i])*pow(1.0-pa, 18-prime[i])
    sb += combi[i]*pow(pb, prime[i])*pow(1.0-pb, 18-prime[i])

print(sa+sb-sa*sb)
