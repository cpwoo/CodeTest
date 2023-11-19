import sys
input = lambda: sys.stdin.readline().rstrip()

s = 1<<15
dp = [[0]*5 for _ in range(s)]

i = 1
while i*i < s:
    dp[i*i][1] = 1
    for j in range(i*i, s):
        dp[j][2] += dp[j-i*i][1]
        dp[j][3] += dp[j-i*i][2]
        dp[j][4] += dp[j-i*i][3]
    i += 1

while True:
    n = int(input())
    if n == 0: break
    ans = 0
    for i in range(1, 5):
        ans += dp[n][i]    
    print(ans)
