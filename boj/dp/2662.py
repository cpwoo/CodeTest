import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

n, m = map(int, input().split())

invest = [[0] for _ in range(m)]
for _ in range(n):
    l = list(map(int, input().split()))
    for i in range(1, len(l)):
        invest[i-1].append(l[i])

dp = [0]*(n+1)
path = [[] for _ in range(n+1)]

for i in range(n+1):
    dp[i] = invest[0][i]
    path[i].append(i)

for i in range(1, m):
    for j in range(n, -1, -1):
        add = 0
        for k in range(1, j+1):
            if dp[j-k] + invest[i][k] > dp[j]:
                dp[j] = dp[j-k] + invest[i][k]
                path[j] = deepcopy(path[j-k])
                add = k
        path[j].append(add)

print(dp[-1])
print(*path[-1])
