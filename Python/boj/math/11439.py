import sys
input = lambda: sys.stdin.readline().rstrip()

n, k, m = map(int, input().split())
sieve = [False, False] + [True]*n
primes = []
for i in range(2, n+1):
    if sieve[i]:
        primes.append(i)
        for j in range(i*i, n+1, i):
            sieve[j] = False

p = [0]*len(primes)
for i in range(len(primes)):
    j = primes[i]
    while j <= n:
        p[i] += n//j - k//j -(n-k)//j
        j *= primes[i]

res = 1
for x, y in zip(primes, p):
    res = res*pow(x, y, m)%m
print(res)
