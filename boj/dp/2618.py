import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def solution(i, j):
    if i > W or j > W: return 0
    if dp[i][j] != -1: return dp[i][j]

    tmp = max(i, j) + 1
    ni = solution(tmp, j) + abs(position[tmp][0]-position[i][0]) + abs(position[tmp][1]-position[i][1])
    nj = solution(i, tmp) + abs(position[j][0]-position[tmp][0]) + abs(position[j][1]-position[tmp][1])
    dp[i][j] = min(ni, nj)
    return dp[i][j]

def backtracking(x, y):
    if x > W or y > W: return
    nc = max(x, y) + 1
    nx = abs(position[nc][0]-position[x][0]) + abs(position[nc][1]-position[x][1])
    ny = abs(position[nc][0]-position[y][0]) + abs(position[nc][1]-position[y][1])

    if dp[nc][y]+nx < dp[x][nc]+ny:
        print(1)
        backtracking(nc, y)
    else:
        print(2)
        backtracking(x, nc)


N, W = int(input()), int(input())
position = [(1, 1), (N, N)]
for _ in range(W):
    position.append(tuple(map(int, input().split())))
dp = [[-1]*(W+2) for _ in range(W+2)]

print(solution(0, 1))
backtracking(0, 1)
