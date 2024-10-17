import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
arr = list(map(int, input().split()))
dp = [0]*(n+1)

for _ in range(m):
    a, b, k = map(int, input().split())
    dp[a-1] += k
    dp[b] -= k

idx = 1
cur = dp[0]
while idx < n:
    dp[idx] += cur
    cur = dp[idx]
    idx += 1

for i in range(n):
    print(arr[i]+dp[i], end=' ')
