import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(n, m, arr):
    dp = [[0]*m for _ in range(n)]

    ans = 0
    for i in range(n):
        for j in range(m):
            if i == 0 or j == 0:
                dp[i][j] = arr[i][j]
            elif arr[i][j] == 0:
                dp[i][j] = 0
            else:
                dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
            
            ans = max(ans, dp[i][j])

    return ans

while True:
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    if (n, m) == (0, 0): break
    print(solve(n, m, arr))
