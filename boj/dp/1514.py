import sys
input = lambda: sys.stdin.readline().rstrip()
INF = sys.maxsize

def go(idx, x, y, z, flag):
    if idx == N:
        return 0
    
    if dp[idx][x][y][z][flag] != -1:
        return dp[idx][x][y][z][flag]
    
    dp[idx][x][y][z][flag] = INF
    
    if (fr[idx]+x+10)%10 == to[idx]:
        dp[idx][x][y][z][flag] = min(go(idx+1, y, z, 0, True), go(idx+1, y, z, 0, False)) 
    else: 
        d = 1 if flag else -1
            
        for k in range(1, 4):
            tx, ty, tz = (x+k*d+10)%10, (y+k*d+10)%10, (z+k*d+10)%10
            
            dp[idx][x][y][z][flag] = min(dp[idx][x][y][z][flag], 1+go(idx, tx, y, z, flag))
            dp[idx][x][y][z][flag] = min(dp[idx][x][y][z][flag], 1+go(idx, tx, ty, z, flag))
            dp[idx][x][y][z][flag] = min(dp[idx][x][y][z][flag], 1+go(idx, tx, ty, tz, flag))
    
    return dp[idx][x][y][z][flag]


N = int(input())
dp = [[[[[-1]*2 for _ in range(10)] for _ in range(10)] for _ in range(10)] for _ in range(N+1)]
fr = list(map(int, input()))
to = list(map(int, input()))

print(min(go(0, 0, 0, 0, True), go(0, 0, 0, 0, False)))
