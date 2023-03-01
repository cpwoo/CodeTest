import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def dfs(node, visited, stack):
    visited[node] = 1
    for nxt in graph[node]:
        if not visited[nxt]:
            dfs(nxt, visited, stack)
    stack.append(node)

def reverse_dfs(node, visited, stack):
    visited[node] = 1
    ids[node] = idx
    stack.append(node)
    for nxt in reverse_graph[node]:
        if visited[nxt] == 0:
            reverse_dfs(nxt, visited, stack)


for _ in range(int(input())):
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
        if not visited[i]:
            dfs(i, visited, stack)
    
    idx = 0
    ids = [-1]*(v+1)
    visited = [0]*(v+1)
    result = []

    while stack:
        scc = []
        node = stack.pop()
        if not visited[node]:
            idx += 1
            reverse_dfs(node, visited, scc)
            result.append(sorted(scc))
    scc_indegree = [0]*(idx+1)

    for i in range(1, v+1):
        for ed in graph[i]:
            if ids[i] != ids[ed]:
                scc_indegree[ids[ed]] += 1
    
    print(scc_indegree[1:].count(0))
