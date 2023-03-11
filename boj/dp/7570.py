import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
children = [0] + list(map(int, input().split()))

dp = [0]*(n+1)
for x in range(1, n+1):
    dp[children[x]] = x

long = -1
cnt = 1

for i in range(1, n):
    if dp[i] < dp[i+1]:
        cnt += 1
        if cnt > long:
            long = cnt
    else:
        cnt = 1

print(n-long if long != -1 else 0)
