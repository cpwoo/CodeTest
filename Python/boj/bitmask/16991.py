import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def dist(a, b):
    return ((a[0]-b[0])**2 + (a[1]-b[1])**2)**0.5

def dfs(cur, path):
    if dp[cur][path]:
        return dp[cur][path]
    
    if path == (1<<n)-1:
        if d[cur][0]:
            return d[cur][0]
        else:
            return INF
    
    cost = INF
    for nxt in range(1, n):
        if not (path>>nxt)&1 and d[cur][nxt]:
            cost = min(cost, d[cur][nxt] + dfs(nxt, path|(1<<nxt)))    
    dp[cur][path] = cost
    return cost


n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]

d = [[0]*n for _ in range(n)]
for i in range(n):
    for j in range(i, n):
        d[i][j] = d[j][i] = dist(points[i], points[j])

dp = [[0]*(1<<n) for _ in range(n)]

print(dfs(0,1))
