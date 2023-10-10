import sys
input = lambda: sys.stdin.readline().rstrip()

N, M, L = map(int, input().split())
arr = [0] + sorted(list(map(int, input().split()))) + [L]
start, end = 1, L-1
result = 0
while start <= end:
    cnt = 0
    mid = (start+end)//2
    for i in range(1, len(arr)):
        if arr[i]-arr[i-1] > mid:
            cnt += (arr[i]-arr[i-1]-1) // mid
    if cnt > M:
        start = mid+1
    else:
        end = mid-1
        result = mid

print(result)
