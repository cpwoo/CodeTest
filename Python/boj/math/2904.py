import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

_max = 1_000_001

n = int(input())
arr = list(map(int, input().split()))

sieve = [True]*_max
sieve[0] = sieve[1] = False

for i in range(2, int(pow(_max, 0.5))+1):
    if sieve[i]:
        for j in range(i*i, _max, i):
            sieve[j] = False

prime = [i for i in range(2, _max) if sieve[i]]
whole = defaultdict(int)
pf = [[0]*len(prime) for _ in range(n)]

for i in range(n):
    for j in range(len(prime)):
        if arr[i] == 1: break
        while arr[i]%prime[j] == 0:
            arr[i] //= prime[j]
            whole[prime[j]] += 1
            pf[i][j] += 1

ans = [1, 0]
for j in range(len(prime)):
    tmp = whole[prime[j]]//n
    cnt = 0
    for i in range(n):
        if tmp > pf[i][j]:
            cnt += (tmp-pf[i][j])
    ans[0] *= pow(prime[j], tmp)
    ans[1] += cnt

print(*ans)
