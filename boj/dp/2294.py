import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
coin = set([int(input()) for _ in range(n)])
dp = [0]*(k+1)

for i in range(1, k+1):
    case = []
    for c in coin:
        if i-c >= 0 and dp[i-c] >= 0:
            case.append(dp[i-c])
    if case:
        dp[i] = min(case)+1
    else:
        dp[i] = -1

print(dp[k])
