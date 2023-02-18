import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
graph = [[int(1e9)]*(n+1) for _ in range(n+1)]
while True:
    a, b = map(int, input().split())
    if (a, b) == (-1, -1):
        break
    graph[a][b] = 1
    graph[b][a] = 1

for i in range(1, n+1):
    graph[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] == 1 or graph[i][j] == 0:
                continue
            elif graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

r = []
for i in range(1, n+1):
    r.append(max(graph[i][1:]))

m = min(r)
print(m, r.count(m))
for i,v in enumerate(r):
    if v == m:
        print(i+1, end=' ')
