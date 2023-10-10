import sys
input = lambda: sys.stdin.readline().rstrip()

INF = int(1e9)

N, M = map(int, input().split())

graph = [[INF]*(N+1) for _ in range(N+1)]
answer = [[0]*(N+1) for _ in range(N+1)]

for i in range(N+1):
    for j in range(N+1):
        if i == j:
            graph[i][j] = 0
            answer[i][j] = INF

for _ in range(M):
    a, b, d = map(int, input().split())
    graph[a][b] = d
    graph[b][a] = d
    answer[a][b] = b
    answer[b][a] = a
    
for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                answer[i][j] = answer[i][k]
                
for i in range(1, N+1):
    for j in range(1, N+1):
        if answer[i][j] == INF:
            print('-', end = ' ')
        else:
            print(answer[i][j], end = ' ')
    print()
