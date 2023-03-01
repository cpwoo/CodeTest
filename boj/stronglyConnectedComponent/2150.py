import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def dfs(node, visited, stack):
    visited[node] = 1
    for nxt in graph[node]:
        if visited[nxt] == 0:
            dfs(nxt, visited, stack)
    stack.append(node)

def reverse_dfs(node, visited, stack):
    visited[node] = 1
    stack.append(node)
    for nxt in reverse_graph[node]:
        if visited[nxt] == 0:
            reverse_dfs(nxt, visited, stack)


v, e = map(int, input().split())
graph = [[] for _ in range(v+1)]
reverse_graph = [[] for _ in range(v+1)]

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    reverse_graph[b].append(a)

stack = []
visited = [0]*(v+1)

for i in range(1, v+1):
    if visited[i] == 0:
        dfs(i, visited, stack)

visited = [0]*(v+1)
result = []

while stack:
    ssc = []
    node = stack.pop()
    if visited[node] == 0:
        reverse_dfs(node, visited, ssc)
        result.append(sorted(ssc))

print(len(result))

result = sorted(result)
for i in result:
    print(*i, -1)
