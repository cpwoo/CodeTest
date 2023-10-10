import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
man = sorted(list(map(int, input().split())))
woman = sorted(list(map(int, input().split())))

if n > m:
    man, woman = woman, man
    n, m = m, n

dp = [[0]*m for _ in range(n)]
dp[0][0] = abs(man[0]-woman[0])

for j in range(1, m-(n-1)):
    dp[0][j] = min(abs(man[0]-woman[j]), dp[0][j-1])

for i in range(1, n):
    for j in range(i, m-(n-i-1)):
        if i == j:
            dp[i][j] = dp[i-1][j-1]+abs(man[i]-woman[j])
        else:
            dp[i][j] = min(dp[i-1][j-1]+abs(man[i]-woman[j]), dp[i][j-1])

print(dp[n-1][m-1])
