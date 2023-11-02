import sys
input = lambda: sys.stdin.readline().rstrip()

def search(idx):
    if dp[idx] < _max:
        return dp[idx]
    
    remain = m-name[idx]
    for i in range(idx+1, n+1):
        if remain >= 0:
            if i == n:
                dp[idx] = 0
                break
            dp[idx] = min(dp[idx], pow(remain,2)+search(i))
            remain -= name[i]+1
    
    return dp[idx]


n, m = map(int, input().split())
name = [int(input()) for _ in range(n)]
_max = pow(m,2)*n
dp = [_max]*(n+1)
dp[n] = 0

print(search(0))
