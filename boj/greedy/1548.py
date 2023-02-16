import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted(list(map(int, input().split())))

res = 1
for x in range(n-1):
    for y in range(n-1, -1, -1):
        if y < x+1:
            continue
        if arr[x] + arr[x+1] > arr[y]:
            res = max(res, y-x+1)

print(res)
