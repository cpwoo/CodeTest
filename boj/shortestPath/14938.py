import sys
input = lambda: sys.stdin.readline().rstrip()

N, M, R = map(int, input().split())
item = list(map(int, input().split()))
arr = [[int(1e9)]*N for _ in range(N)]

for _ in range(R):
    start, end, dist = map(int, input().split())
    arr[start-1][end-1] = min(arr[start-1][end-1], dist)
    arr[end-1][start-1] = min(arr[end-1][start-1], dist)
    
for k in range(N):
    for i in range(N):
        for j in range(N):
            arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
            if i == j:
                arr[i][j] = 0

_max = 0
for i in range(N):
    tmp = 0
    for j in range(N):
        if arr[i][j] <= M:
            tmp += item[j]
        
    _max = max(_max, tmp)
    
print(_max)
