import sys
input = lambda: sys.stdin.readline().rstrip()

def power(a,b):
    if b == 0:
        return 1
    if b % 2 == 1:
        return (power(a,b//2)**2 * a) % p
    else:
        return (power(a,b//2)**2) % p


p = 1_000_000_007
n, k = map(int, input().split())

fact = [1] * (n+1)

for i in range(2, n+1):
    fact[i] = fact[i-1] * i % p

a = fact[n]
b = (fact[n-k] * fact[k]) % p

print((a % p) * (power(b, p-2) % p) % p)
