import sys
input = lambda: sys.stdin.readline().rstrip()

def search(cur, cnt, cost):
    global result

    if cnt == N:
        result = min(result, cost)
        return
    
    for nxt in range(N):
        if not visited[nxt]:
            visited[nxt] = True
            search(nxt, cnt+1, cost+graph[cur][nxt])
            visited[nxt] = False


N, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

visited = [False]*N
result = sys.maxsize
visited[K] = True

search(K, 1, 0)

print(result)
