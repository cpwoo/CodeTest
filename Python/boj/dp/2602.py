import sys
input = lambda: sys.stdin.readline().rstrip()

target, first, second = input(), input(), input()

T, L = len(target), len(first)

dp = [[[0]*2 for _ in range(T)] for _ in range(L)]

for i in range(L):
    if first[i] == target[0]:
        dp[i][0][0] = 1
    if second[i] == target[0]:
        dp[i][0][1] = 1

for i in range(L):
    for j in range(1, T):
        if first[i] == target[j]:
            for k in range(i):
                dp[i][j][0] += dp[k][j-1][1]
        if second[i] == target[j]:
            for k in range(i):
                dp[i][j][1] += dp[k][j-1][0]

answer = 0
for i in range(L):
    answer += dp[i][-1][0]+dp[i][-1][1]

print(answer)
