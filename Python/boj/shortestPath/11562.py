import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
graph = [[250]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    s, e, state = map(int, input().split())
    graph[s][e] = 0
    graph[e][s] = 1-state

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][k]+graph[k][j] < graph[i][j]:
                graph[i][j] = graph[i][k]+graph[k][j]


for _ in range(int(input())):
    s, e = map(int, input().split())
    print(graph[s][e])
