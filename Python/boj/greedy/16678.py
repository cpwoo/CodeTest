import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [int(input()) for _ in range(n)]

ret = 0
defile = 1

for a in sorted(arr):
    if a >= defile:
        ret += a-defile
        defile += 1

print(ret)
