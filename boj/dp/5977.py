import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def calc(i):
    return dp[i-1]-total[i]


n, k = map(int, input().split())
arr = [int(input()) for _ in range(n)]
total = [0]*(n+1)
for i in range(1, n+1):
    total[i] = total[i-1] + arr[i-1]

dp = [0]*(n+1)
q = deque()
for i in range(1, n+1):
    while q and q[0] < i-k:
        q.popleft()
    while q and calc(q[-1]) <= calc(i):
        q.pop()
    q.append(i)
    dp[i] = total[i] + calc(q[0])
    if i <= k:
        dp[i] = max(dp[i], total[i])

print(dp[n])
