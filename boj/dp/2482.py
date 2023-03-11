import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_003

def find_color(n, k):
    if k > n/2:
        dp[n][k] = 0
        return 0
    
    if dp[n][k] != -1:
        return dp[n][k]
    else:
        dp[n][k] = find_color(n-1, k) % MOD + find_color(n-2, k-1) % MOD
        return dp[n][k] % MOD


N, K = int(input()), int(input())

dp = [[-1]*(K+1) for _ in range(N+1)]

for i in range(N+1):
    dp[i][0] = 1
    dp[i][1] = i

print(find_color(N, K))
