import sys
input = lambda: sys.stdin.readline().rstrip()

def pick(turn, i, j):
    if i > j: return 0
    if dp[i][j]: return dp[i][j]

    if turn:
        score = max(pick(False, i+1, j)+cards[i], pick(False, i, j-1)+cards[j])
        dp[i][j] = score
        return score

    elif not turn:
        score = min(pick(True, i+1, j), pick(True, i, j-1))
        dp[i][j] = score
        return score


for _ in range(int(input())):
    n = int(input())
    cards = list(map(int, input().split()))
    dp = [[0 for _ in range(n)] for _ in range(n)]
    pick(True, 0, n-1)
    print(dp[0][n-1])
