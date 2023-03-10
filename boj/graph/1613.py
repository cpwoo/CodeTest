import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
graph = [[0]*n for _ in range(n)]

for _ in range(k):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1
    
for p in range(n):
    for i in range(n):
        for j in range(n):
            if i != j and not graph[i][j] and graph[i][p] and graph[p][j]:
                graph[i][j] = 1
                
for _ in range(int(input())):
    s, e = map(int, input().split())
    if graph[s-1][e-1]: 
        print(-1)
    elif graph[e-1][s-1]:
        print(1)
    else:
        print(0)
