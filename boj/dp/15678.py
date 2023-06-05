import sys
input = lambda: sys.stdin.readline().rstrip()

# monotonic queue
# deque를 이용해 배열 순회, 작은 인덱스의 dp값들을 이용해 현재 인덱스의 dp 채우는 bottom-up
# dp[i] = 도착점이 i인 경우의 최대 점수, deque 안에는 dp값들의 가장 긴 감소하는 부분수열
# dp[i] = (dp[i-d] ~ dp[i-1])의 최대값 + arr[i]

# 1. 인덱스가 i-d 보다 작다면 제외
# 2. dp[i] = q[0][1] + arr[i] (q가 가장 긴 감소하는 부분수열이니까 최대값은 q[0][1])
# 3. q 뒤에서 dp[i]보다 작은 값 모두 제외하고 dp[i] 넣을 것

from collections import deque

n, d = map(int, input().split())
arr = list(map(int, input().split()))
dp = [0]*n

q = deque()
for i in range(n):
    dp[i] = arr[i]
    while q and q[0][0] < i-d:
        q.popleft()
    if q:
        dp[i] = max(dp[i], q[0][1]+arr[i])
    while q and q[-1][1] < dp[i]:
        q.pop()
    q.append([i, dp[i]])

print(max(dp))
