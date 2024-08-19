import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

arr = []
for _ in range(n):
    a, b = map(int, input().split())
    if a > b:
        arr.append([a, b])

arr.sort(reverse=True)

ret = m
start, end = -1, -1
for i in range(len(arr)):
    From, To = arr[i]
    if (start, end) == (-1, -1):
        start, end = From, To
    else:
        if From >= end:
            end = min(end, To)
        else:
            ret += 2*(start-end)
            start, end = From, To

ret += 2*(start-end)

print(ret)
