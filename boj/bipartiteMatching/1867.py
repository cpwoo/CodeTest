import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(start):
    if visited[start]: return 0
    visited[start] = True
    for i in graph[start]:
        if d[i] == 0 or dfs(d[i]):
            d[i] = start
            return 1
    return 0


n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
d = [0]*(n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

cnt = 0
for i in range(1, n+1):
    visited = [False]*(n+1)
    dfs(i)

print(len(d)-d.count(0))
