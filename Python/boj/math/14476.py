import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

n = int(input())
arr = list(map(int, input().split()))

lg, rg = [0]*(n+1), [0]*(n+1)

lg[0] = arr[0]
rg[n-1] = arr[n-1]

for i in range(1, n):
    lg[i] = gcd(lg[i-1], arr[i])

for i in range(n-2, -1, -1):
    rg[i] = gcd(rg[i+1], arr[i])

ans = [0, 0]
for i in range(n):
    res = gcd(lg[i-1], rg[i+1])
    if arr[i]%res != 0 and ans[0] < res:
        ans[0] = res
        ans[1] = arr[i]

print(" ".join(map(str, ans)) if ans != [0]*2 else -1)
