import sys
input = lambda: sys.stdin.readline().rstrip()

A, B = map(int, input().split())
L = int(B**0.5)+1
sieve = [True]*L
sieve[0] = sieve[1] = False

for i in range(int(L**0.5)+1):
    if sieve[i]:
        for j in range(2*i, L, i):
            sieve[j] = False

s = set()
for i in range(2, L):
    if sieve[i]:
        cur = i*i
        while cur <= B:
            if cur >= A:
                s.add(cur)
            cur *= i

print(len(s))
