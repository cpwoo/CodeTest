import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
buildings = [list(map(int, input().split())) for _ in range(n)]

# 어차피 기지국은 x축 위에 설치되기 때문에 x축 간의 거리로 바꿔준다.
for building in buildings:
    if building[1] < 0:
        building[1] *= -1

buildings.sort()

dp = [0]*n
dp[0] = buildings[0][1]*2

for i in range(1, n):
    maxHeight = buildings[i][1]
    dp[i] = dp[i-1]+buildings[i][1]*2
    for j in range(i-1, -1, -1):
        maxHeight = max(maxHeight, buildings[j][1])
        if j > 0:
            dp[i] = min(dp[i], max(2*maxHeight, buildings[i][0]-buildings[j][0])+dp[j-1])
        else:
            dp[i] = min(dp[i], max(2*maxHeight, buildings[i][0]-buildings[j][0]))

print(dp[-1])
