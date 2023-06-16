import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

def find(pizza, L):
    c = defaultdict(int)
    for i in range(L):
        tmp = pizza[i:] + pizza[:i]
        pre = 0
        for num in tmp:
            pre += num
            c[pre] += 1
    c[sum(pizza)] = 1
    return c


k = int(input())
m, n = map(int, input().split())
A = [int(input()) for _ in range(m)]
B = [int(input()) for _ in range(n)]

c1, c2 = find(A, m), find(B, n)

res = c1.get(k, 0) + c2.get(k, 0)
for num in c1:
    if k-num in c2:
        res += c1[num] * c2[k-num]

print(res)
