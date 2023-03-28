import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(start):
    if visited[start] == 1:
        return 0
    visited[start] = 1
    for i in graph[start]:
        if d[i] == 0 or dfs(d[i]):
            d[i] = start
            return 1

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
d = [0]*(m+1)

for i in range(1, n+1):
    arr = list(map(int, input().split()))
    for j in arr[1:]:
        graph[i].append(j)

for i in range(1, n+1):
    visited = [0]*(n+1)
    dfs(i)

print(len(d) - d.count(0))
