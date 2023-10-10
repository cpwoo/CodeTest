import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
arr = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)

dp = [1] * (n+1)

for i in range(1, n+1):
    for b in arr[i]:
        dp[b] = max(dp[b], dp[i]+1)

print(*dp[1:])
