import sys
input = lambda: sys.stdin.readline().rstrip()

# sparse table

m = int(input())
f = [0] + list(map(int, input().split()))
dp = [[f[i]] for i in range(m+1)]

# 1 < m <= 200000 
# 0 < logm <= 17.609...
for j in range(1, 19):
    for i in range(1, m+1):
        dp[i].append(dp[dp[i][j-1]][j-1])

q = int(input())
for _ in range(q):
    n, x = map(int, input().split())
    for j in range(18, -1, -1):
        if n >= (1<<j):
            n -= (1<<j)
            x = dp[x][j]
    print(x)
