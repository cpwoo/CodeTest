import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

def solve(s, a, b, c):
    if s == 0:
        if a != 0 or b != 0 or c != 0: return 0
        else: return 1
    if a < 0 or b < 0 or c < 0: return 0
    if dp[s][a][b][c] != -1: return dp[s][a][b][c]
    
    dp[s][a][b][c] = 0
    for i in range(2):
        for j in range(2):
            for k in range(2):
                if i+j+k == 0: continue
                dp[s][a][b][c] += solve(s-1, a-i, b-j, c-k)
    
    dp[s][a][b][c] %= MOD
    return dp[s][a][b][c]


s, a, b, c = map(int, input().split())
dp = [[[[-1]*51 for _ in range(51)] for _ in range(51)] for _ in range(51)]

print(solve(s, a, b, c))
