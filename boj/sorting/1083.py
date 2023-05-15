import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
s = int(input())
for i in range(n-1):
    if s == 0:
        break
    mx, idx = arr[i], i
    for j in range(i+1, min(n, i+1+s)):
        if mx < arr[j]:
            mx, idx = arr[j], j
    s -= idx-i
    for j in range(idx, i, -1):
        arr[j] = arr[j-1]
    arr[i] = mx
print(*arr)
