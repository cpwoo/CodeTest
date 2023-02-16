import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(s, e, dist):
    global answer
    visited[s] = True
    for i in range(1, n+1):
        if graph[s][i] > 0 and not visited[i]:
            if i == e:
                answer = dist+graph[s][i]
            else:
                dfs(i, e, dist+graph[s][i])


n, m = map(int, input().split())
graph = [[0]*(n+1) for _ in range(n+1)]
answer = 0

for _ in range(n-1):
    a, b, d = map(int, input().split())
    graph[a][b] = d
    graph[b][a] = d

for _ in range(m):
    visited = [0]*(n+1)
    a, b = map(int, input().split())
    dfs(a, b, 0)
    print(answer)
