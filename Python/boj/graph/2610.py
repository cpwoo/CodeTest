import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

n, m = int(input()), int(input())
dist = [[INF]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    dist[a][b] = dist[b][a] = 1
    
for i in range(1, n+1):
    dist[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

d = {}
for i in range(1, n+1):
    tmp = []
    _max = 0
    for j in range(1, n+1):
        if dist[i][j] != INF:
            tmp.append(j)
            _max = max(_max, dist[i][j])
    tmp = tuple(tmp)
    if tmp not in d:
        d[tmp] = [i, _max]
    else:
        if d[tmp][1] > _max:
            d[tmp] = [i, _max]

arr = [i[0] for i in d.values()]
print(len(arr))
print(*sorted(arr), sep="\n")
