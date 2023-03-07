import sys
input = lambda: sys.stdin.readline().rstrip()

w, n = map(int, input().split())
arr = list(map(int, input().split()))
dp = [False]*w

for i in range(n):
    for j in range(i+1, n):
        if arr[i]+arr[j] < w and dp[w-arr[i]-arr[j]]:
            print("YES")
            exit()
    for j in range(i):
        if arr[i]+arr[j] < w:
            dp[arr[i]+arr[j]] = True
else:
    print("NO")
