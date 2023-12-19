import sys
input = lambda: sys.stdin.readline().rstrip()

s1, s2 = input(), input()
n, m = len(s1), len(s2)

dp = [[0]*(m+1) for _ in range(n+1)]

for i in range(n):
    for j in range(m):
        if s1[i] == s2[j]:
            dp[i+1][j+1] = dp[i][j]+1
        else:
            dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1])

ret = ""
cnt = dp[-1][-1]
row, col = n, m

while cnt:
    if dp[row-1][col] == cnt:
        row -= 1
    elif dp[row][col-1] == cnt:
        col -= 1
    else:
        ret += s1[row-1]
        cnt -= 1
        row -= 1
        col -= 1

print(ret[::-1])
