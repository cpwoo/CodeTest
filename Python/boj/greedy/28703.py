import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
mx = max(arr)
for i in range(n):
    while arr[i]*2 <= mx:
        arr[i] *= 2

arr.sort()
ret = arr[-1]-arr[0]
for i in range(n-1):
    arr[i] *= 2
    ret = min(ret, arr[i]-arr[i+1])

print(ret)
