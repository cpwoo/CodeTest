import sys
input = lambda: sys.stdin.readline().rstrip()

n, h = map(int, input().split())

down = [0]*(h+1)
up = [0]*(h+1)

_min = 1000001
cnt = 0

for i in range(n):
    if i%2 == 0:
        down[int(input())] += 1
    else:
        up[int(input())] += 1

for i in range(h-1, 0, -1):
    down[i] += down[i+1]
    up[i] += up[i+1]

for i in range(1, h+1):
    if _min > (down[i] + up[h-i+1]):
        _min = down[i] + up[h-i+1]
        cnt = 1
    elif _min == (down[i] + up[h-i+1]):
        cnt += 1

print(_min, cnt)
