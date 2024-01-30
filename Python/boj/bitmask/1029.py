import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(cur, path, price):
    if dp[cur][path][price]:
        return dp[cur][path][price]
    
    cnt = 0
    for nxt in range(1, n):
        if board[cur][nxt] < price or path&(1<<nxt):
            continue
        cnt = max(cnt, 1 + dfs(nxt, path|(1<<nxt), board[cur][nxt]))
    
    dp[cur][path][price] = cnt
    
    return cnt


n = int(input())
board = [list(map(int, input())) for _ in range(n)]
dp = [[[0]*10 for _ in range(1<<n)] for _ in range(n)]
print(1 + dfs(0,1,0))
