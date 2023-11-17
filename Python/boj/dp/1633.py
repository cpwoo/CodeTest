import sys
input = lambda: sys.stdin.readline().rstrip()

arr = []
for row in sys.stdin:
    arr.append(list(map(int, row.split())))

n = len(arr)
dp = [[[0]*16 for _ in range(16)] for _ in range(n+1)]

for i in range(n):
    for w in range(16):
        for b in range(16):
            if w < 15:
                dp[i+1][w+1][b] = max(dp[i+1][w+1][b], dp[i][w][b]+arr[i][0])
            if b < 15:
                dp[i+1][w][b+1] = max(dp[i+1][w][b+1], dp[i][w][b]+arr[i][1])
            dp[i+1][w][b] = max(dp[i+1][w][b], dp[i][w][b])

print(dp[n][15][15])
