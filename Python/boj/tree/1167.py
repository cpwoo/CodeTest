import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**5)

def dfs(x, y):
    for a, b in graph[x]:
        if visited[a] == -1:
            visited[a] = b+y
            dfs(a, b+y)


n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n):
    w = list(map(int, input().split()))
    for i in range(1, len(w)-2, 2):
        graph[w[0]].append([w[i], w[i+1]])

visited = [-1]*(n+1)
visited[1] = 0
dfs(1, 0)

start = visited.index(max(visited))
visited = [-1]*(n+1)
visited[start] = 0
dfs(start, 0)

print(max(visited))
