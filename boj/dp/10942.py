import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
dp = [[0]*n for _ in range(n)]

for idx in range(n):
    for start in range(n):
        end = start + idx
        if end >= n: break
        
        if idx == 0:
            dp[start][end] = 1
            continue
        
        if idx == 1:
            if arr[start] == arr[end]:
                dp[start][end] = 1
                continue
                
        if arr[start] == arr[end] and dp[start+1][end-1]:
            dp[start][end] = 1

for _ in range(m):
    start, end = map(int, input().split())
    print(dp[start-1][end-1])
