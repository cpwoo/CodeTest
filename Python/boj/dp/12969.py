import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(idx, a, b, p):
    if idx == n:
        return p == k
    if dp[idx][a][b][p]: return False
    dp[idx][a][b][p] = True

    ans[idx] = "A"
    if dfs(idx+1, a+1, b, p): return True

    ans[idx] = "B"
    if dfs(idx+1, a, b+1, p+a): return True

    ans[idx] = "C"
    if dfs(idx+1, a, b, p+a+b): return True

    return False


n, k = map(int, input().split())
_max = n*(n-1)//2
dp = [[[[False]*(_max+1) for _ in range(n+1)] for _ in range(n+1)] for _ in range(n+1)]

ans = [""]*(n+1)

print("".join(ans) if dfs(0, 0, 0, 0) else -1)
