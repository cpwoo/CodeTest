import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(idx, tot):
    if tot < 0:
        return -sys.maxsize
    if idx == N:
        return 0
    if dp[idx][tot] != -1:
        return dp[idx][tot]
    
    a, b, c, d = arr[idx]

    dp[idx][tot] = max(dfs(idx+1, tot-a)+b, dfs(idx+1, tot-c)+d)
    
    return dp[idx][tot]


N, K = map(int, input().split())
dp = [[-1]*(K+1) for _ in range(N)]
arr = [list(map(int, input().split())) for _ in range(N)]

print(dfs(0, K))
