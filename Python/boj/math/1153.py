import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(n):
    for i in range(len(prime)):
        for j in range(len(prime)):
            tot = prime[i]+prime[j]
            if tot == n:
                ans.extend([prime[i],prime[j]])
                return
            elif tot > n:
                break
            

_max = 1_000_001

sieve = [True]*_max
sieve[0] = sieve[1] = False

for i in range(4, _max, 2):
    sieve[i] = False

for i in range(3, int(pow(_max,0.5))+1, 2):
    if sieve[i]:
        for j in range(i*i, _max, i):
            sieve[j] = False

n = int(input())
prime = [i for i in range(2, n+1) if sieve[i]]

if n < 8:
    print(-1)
else:
    if n%2 == 0:
        ans = [2, 2]
        n -= 4
    else:
        ans = [2, 3]
        n -= 5
    solve(n)
    print(*ans)
