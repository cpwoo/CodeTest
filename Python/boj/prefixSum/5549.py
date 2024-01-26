import sys
input = lambda: sys.stdin.readline().rstrip()

M, N = map(int, input().split())
K = int(input())

arr = [list(input()) for _ in range(M)]
tot = [[[0]*3 for _ in range(N+1)] for _ in range(M+1)]

for i in range(1, M+1):
    for j in range(1, N+1):
        if arr[i-1][j-1] == "J":
            tot[i][j][0] += 1
        if arr[i-1][j-1] == "O":
            tot[i][j][1] += 1
        if arr[i-1][j-1] == "I":
            tot[i][j][2] += 1
        
        for p in range(3):
            tot[i][j][p] = tot[i][j][p] + tot[i-1][j][p] + tot[i][j-1][p] - tot[i-1][j-1][p]

for _ in range(K):
    a, b, c, d = map(int, input().split())
    print(*[tot[c][d][p] - tot[c][b-1][p] - tot[a-1][d][p] + tot[a-1][b-1][p] for p in range(3)])
