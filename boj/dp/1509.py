import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**8)

s = input()
L = len(s)

dp = [2500]*(L+1)
dp[-1] = 0
is_p = [[0]*L for _ in range(L)]

for i in range(L):
    is_p[i][i] = 1

for i in range(1, L):
    if s[i-1] == s[i]:
        is_p[i-1][i] = 1

for j in range(3, L+1):
    for start in range(L-j+1):
        end = start+j-1
        if s[start] == s[end] and is_p[start+1][end-1]:
            is_p[start][end] = 1

for end in range(L):
    for start in range(end+1):
        if is_p[start][end]:
            dp[end] = min(dp[end], dp[start-1]+1)
        else:
            dp[end] = min(dp[end], dp[end-1]+1)

print(dp[L-1])
