import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

N, K = map(int, input().split())
dp = [-1] * 100001
dp[N] = 0

q = deque()
q.append(N)

cnt = 0
while q:
    x = q.popleft()
    if x == K:
        cnt += 1 
    for nx in (x-1, x+1, 2*x):
        if (0 <= nx < 100001) and (dp[nx] == -1 or dp[nx] >= dp[x]+1):
            dp[nx] = dp[x]+1
            q.append(nx)

print(dp[K])
print(cnt)
