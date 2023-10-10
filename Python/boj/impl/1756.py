import sys
input = lambda: sys.stdin.readline().rstrip()

d, n = map(int, input().split())
oven = list(map(int, input().split()))
pizza = list(map(int, input().split()))

for i in range(1, d):
    if oven[i] > oven[i-1]:
        oven[i] = oven[i-1]

idx = 0
for i in range(d-1, -1, -1):
    if pizza[idx] <= oven[i]:
        idx += 1

    if idx == n:
        print(i+1)
        break

if idx != n:
    print(0)
