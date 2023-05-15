import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
arr = list(map(int, input().split()))
dp = [0]*(N+1)
for i in range(1, N+1):
    _max, _min = 0, 10001
    for j in range(i, 0, -1):
        _max = max(_max, arr[j-1])
        _min = min(_min, arr[j-1])
        dp[i] = max(dp[i], _max-_min+dp[j-1])

print(dp[N])
