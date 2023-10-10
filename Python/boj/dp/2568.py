import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

q, c, d, e = [], [], [], []

for _ in range(int(input())):
    a, b = map(int, input().split())
    q.append((a,b))
q.sort()

for a,b in q:
    s = bisect_left(c,b)
    if len(c) != s:
        c[s] = b
    else:
        c.append(b)
    d.append(s+1)

s = len(c)

print(len(q)-s)

for i in range(len(d)-1, -1, -1):
    if d[i] == s:
        s -= 1
    else:
        e.append(q[i][0])

for i in e[::-1]:
    print(i)
