import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def distance(a, b):
    return abs(a[0]-b[0])+abs(a[1]-b[1])

n, k = map(int, input().split())
points = [list(map(int, input().split())) for _ in range(n)]
dp = [[INF]*(k+1) for _ in range(n)]

for i in range(k+1):
    dp[0][i] = 0

for i in range(n-1):
    for j in range(k+1):
        if dp[i][j] == INF: continue
        for m in range(j+1):
            if i+m+1 >= n: continue
            dp[i+m+1][j-m] = min(dp[i+m+1][j-m], dp[i][j]+distance(points[i], points[i+m+1]))

print(min(dp[n-1][:]))
