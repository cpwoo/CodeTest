import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = int(input()), int(input())

graph = [[int(1e9) for _ in range(n+1)] for _ in range(n+1)]
path = [[[] for _ in range(n+1)] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)
    path[a][b] = [a, b]

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if i != j:
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]
                    path[i][j] = path[i][k][:-1] + path[k][j]

for i in graph[1:]:
    for j in i[1:]:
        print(0 if j == int(1e9) else j, end=' ')
    print()

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] == int(1e9) or i == j:
            print(0)
        else:
            print(len(path[i][j]), *path[i][j])
