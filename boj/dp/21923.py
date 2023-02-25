import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

# 위로 비행하는 dp
dp1 = [[-1e9]*m for _ in range(n)]
dp1[n-1][0] = arr[n-1][0]

# 아래로 비행하는 dp
dp2 = [[-1e9]*m for _ in range(n)]
dp2[n-1][m-1] = arr[n-1][m-1]

# 위로 비행하나 아래로 비행하나 탐색은 역순으로 진행!!

for i in range(n-1, -1, -1):
    for j in range(m):
        if (i, j) == (n-1, 0): continue # 시작점은 pass
        if i < n-1: dp1[i][j] = max(dp1[i][j], dp1[i+1][j]) #좌우비교 
        if j > 0: dp1[i][j] = max(dp1[i][j], dp1[i][j-1]) #아래위비교
        dp1[i][j] += arr[i][j]
        
for i in range(n-1, -1, -1):
    for j in range(m-1, -1, -1):
        if (i, j) == (n-1, m-1): continue # 끝점은 pass
        if i < n-1: dp2[i][j] = max(dp2[i][j], dp2[i+1][j]) #좌우비교
        if j < m-1: dp2[i][j] = max(dp2[i][j], dp2[i][j+1]) #위아래비교
        dp2[i][j] += arr[i][j]
        
_max = -1e9
for i in range(n):
    for j in range(m):
        _max = max(_max, dp1[i][j]+dp2[i][j])

print(_max)
