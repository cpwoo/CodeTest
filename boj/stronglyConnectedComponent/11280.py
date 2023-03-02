import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def dfs(node):
    visited[node] = 1
    for nxt in graph[node]:
        if not visited[nxt]:
            dfs(nxt)
    stack.append(node)

def reverse_dfs(node):
    visited[node] = 1
    ids[node] = idx
    for nxt in reverse_graph[node]:
        if not visited[nxt]:
            reverse_dfs(nxt)


n, m = map(int, input().split())
graph = [[] for _ in range(n*2+1)]
reverse_graph = [[] for _ in range(n*2+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[-a].append(b)
    reverse_graph[b].append(-a)
    graph[-b].append(a)
    reverse_graph[a].append(-b)

stack = []
visited = [False]*(n*2+1)
for node in range(1, n*2+1):
    if not visited[node]:
        dfs(node)

visited = [False]*(n*2+1)
ids = [-1]*(n*2+1)
idx = 0
while stack:
    node = stack.pop()
    if not visited[node]:
        reverse_dfs(node)
        idx += 1

for i in range(1, n+1):
    if ids[i] == ids[-i]:
        print(0)
        break
else:
    print(1)
