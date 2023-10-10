import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = int(input()), int(input())
graph = [[0 for _ in range(n)] for _ in range(n)]

for _ in range(m):
    a, b = map(int, input().split())
    if not graph[a-1][b-1]:
        graph[a-1][b-1] = 1

        
for k in range(n):
    for i in range(n):
        for j in range(n):
            if i != j and not graph[i][j] and graph[i][k] and graph[k][j]:
                graph[i][j] = 1
                
for i in range(n):
    cnt = 0
    for j in range(n):
        if not graph[i][j] and not graph[j][i]:
            cnt += 1
    print(cnt-1)
