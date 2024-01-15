import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)])

ret = 0
start, end = arr[0][0], arr[0][1]

for i in range(1, n):
    if arr[i][0] <= end:
        if arr[i][1] > end:
            end = arr[i][1]
    else:
        ret += end-start
        start, end = arr[i][0], arr[i][1]

ret += end-start

print(ret)
