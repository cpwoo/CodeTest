import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def scale(weight, depth, left, right, possible):
    new = abs(left-right)
    if new not in possible:
        possible.append(new)
    if depth == n:
        return 0
    if dp[depth][new] == 0:
        scale(weight, depth+1, left+weight[depth], right, possible)
        scale(weight, depth+1, left, right+weight[depth], possible)
        scale(weight, depth+1, left, right, possible)
        
        dp[depth][new] = 1


n = int(input())
weight = list(map(int, input().rstrip().split()))
m = int(input())
marble = list(map(int, input().rstrip().split()))
dp = [[0 for _ in range(15001)] for _ in range(n+1)]
possible = []

scale(weight, 0, 0, 0, possible)

for i in range(m):
    if marble[i] in possible:
        print('Y', end=' ')
    else:
        print('N', end=' ')
