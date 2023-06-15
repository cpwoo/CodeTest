import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted([sorted(list(map(int, input().split()))) for _ in range(n)])
dp = [1]*n

for i in range(1, n):
    for j in range(i):
        if arr[j][1] <= arr[i][1]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))
