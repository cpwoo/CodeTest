import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

dy, dx = [1, -1, 0, 0, 0], [0, 0, 1, -1, 0]

n = int(input())
cakes = [list(map(int, input().split())) for _ in range(n+1)]
distance = [[INF]*5 for _ in range(n+1)]

for k in range(4):
    distance[0][k] = 1
distance[0][4] = 0

for i in range(1, n+1):
    for k in range(5):
        y, x = cakes[i][0]+dy[k], cakes[i][1]+dx[k]
        for j in range(5):
            ey, ex = cakes[i-1][0]+dy[j], cakes[i-1][1]+dx[j]
            distance[i][k] = min(distance[i][k], abs(ey-y)+abs(ex-x)+distance[i-1][j])

print(min(distance[-1]))
