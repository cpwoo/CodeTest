import sys
input = lambda: sys.stdin.readline().rstrip()

MAX = 5_000_001

sieve = list(range(MAX))
sieve[0] = sieve[1] = -1
for i in range(2, int(MAX**0.5)+1):
    if sieve[i] == i:
        for j in range(2*i, MAX, i):
            if sieve[j] == j:
                sieve[j] = i

n = int(input())
arr = list(map(int, input().split()))

for a in arr:
    ans = []
    while a > 1:
        ans.append(sieve[a])
        a //= sieve[a]
    print(*ans)
