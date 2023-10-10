import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

cnt = 0
while sum(arr):
    chk = 0
    for i in range(n):
        if arr[i] == 0:
            continue
        if arr[i]&1:
            arr[i] -= 1
            cnt += 1
            chk = 1
    if not chk:
        for i in range(n):
            arr[i] //= 2
        cnt += 1

print(cnt)
