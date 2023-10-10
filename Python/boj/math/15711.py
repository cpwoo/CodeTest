import sys
input = lambda: sys.stdin.readline().rstrip()

def check(x):
    for i in range(len(q)):
        if q[i]*q[i] > x:
            break
        if x%q[i] == 0:
            return 0
    return 1


_max = 2_000_001
sieve = [True]*_max
sieve[0] = sieve[1] = False
for i in range(2, int(_max**0.5)+1):
    if sieve[i]:
        for j in range(2*i, _max, i):
            sieve[j] = False

q = [i for i in range(2, _max) if sieve[i]]

for _ in range(int(input())):
    x, y = map(int, input().split())
    z = x+y
    if z < 4:
        print("NO")
    elif z%2 == 0:
        print("YES")
    else:
        z -= 2
        print("YES" if check(z) else "NO")
