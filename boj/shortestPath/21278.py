import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
cost = [[int(1e9)]*N for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    cost[a-1][b-1] = 1
    cost[b-1][a-1] = 1

for k in range(N):
    cost[k][k] = 0
    for i in range(N):
        for j in range(N):
            cost[i][j] = min(cost[i][j], cost[i][k] + cost[k][j])

_max = int(1e9)
for i in range(N-1):
    for j in range(1, N):
        total = 0
        for k in range(N):
            total += min(cost[k][i], cost[k][j])
        if _max > total * 2:
            _max = 2 * total
            answer = [i+1, j+1, 2*total]

print(*answer)
