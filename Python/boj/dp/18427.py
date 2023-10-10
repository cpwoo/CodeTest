import sys
input = lambda: sys.stdin.readline().rstrip()

N, M, H = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [1] + [0]*(H+1)

for i in range(N):
    for j in range(H, -1, -1):
        for k in arr[i]:
            if j-k >= 0:
                dp[j] = (dp[j] + dp[j-k]) % 10007

print(dp[H])
