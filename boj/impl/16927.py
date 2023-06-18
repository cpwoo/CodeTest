import sys
input = lambda: sys.stdin.readline().rstrip()

N, M, R = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]

turns = [(2*((N-(2*k))+(M-(2*k)))-4) for k in range(min(N,M)//2)]

for k in range(min(N,M)//2):
    for r in range(R%turns[k]):
        tmp = data[k][k]
        for i in range(1+k, M-k):
            data[k][i-1] = data[k][i]
        for i in range(1+k, N-k):
            data[i-1][M-1-k] = data[i][M-1-k]
        for i in range(1+k, M-k):
            data[N-1-k][M-i] = data[N-1-k][M-1-i]
        for i in range(1+k, N-k):
            data[N-i][k] = data[N-1-i][k]
        data[1+k][k] = tmp

for d in data:
    print(*d)
