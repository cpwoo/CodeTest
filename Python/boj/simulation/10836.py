import sys
input = lambda : sys.stdin.readline().rstrip()

m, n = map(int, input().split())
grow = [1]*(2*m-1)

for _ in range(n):
    a, b, c = map(int, input().split())
    for i in range(a, a+b):
        grow[i] += 1
    for i in range(a+b, 2*m-1):
        grow[i] += 2

s = " ".join(str(x) for x in grow[m:])

for i in range(m-1, -1, -1):
    print(grow[i], s)
