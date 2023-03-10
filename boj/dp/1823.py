import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def profit(start, end, cnt):
    if start == end:
        return cnt * arr[start]
    
    if dp[start][end]:
        return dp[start][end]
    
    dp[start][end] = max(profit(start+1, end, cnt+1)+cnt*arr[start], profit(start, end-1, cnt+1)+cnt*arr[end])
    return dp[start][end]


n = int(input())
arr = [int(input()) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]
print(profit(0, n-1, 1))
