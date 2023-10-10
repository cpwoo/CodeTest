import sys
input = lambda: sys.stdin.readline().rstrip()

N, M, K = map(int, input().split())
board = [list(input()) for _ in range(N)]

s = [[0]*(M+1) for _ in range(N+1)]

for r in range(1, N+1):
    for c in range(1, M+1):
        if (r+c)%2 == 0:
            if board[r-1][c-1] == "B":
                s[r][c] = s[r-1][c] + s[r][c-1] - s[r-1][c-1]
            else:
                s[r][c] = s[r-1][c] + s[r][c-1] - s[r-1][c-1] + 1
        else:
            if board[r-1][c-1] == "W":
                s[r][c] = s[r-1][c] + s[r][c-1] - s[r-1][c-1]
            else:
                s[r][c] = s[r-1][c] + s[r][c-1] - s[r-1][c-1] + 1

_max, _min = -int(1e9), int(1e9)
for r in range(K, N+1):
    for c in range(K, M+1):
        _max = max(s[r][c] - s[r-K][c] - s[r][c-K] + s[r-K][c-K], _max)
        _min = min(s[r][c] - s[r-K][c] - s[r][c-K] + s[r-K][c-K], _min)

print(min(_min, _max, K*K-_min, K*K-_max))
