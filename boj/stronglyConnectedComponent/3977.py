import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(node, visited, stack):
    visited[node] = 1
    for nxt in graph[node]:
        if visited[nxt] == 0:
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
    n, m = map(int, input().split())
    graph = [[] for _ in range(n)]
    reverse_graph = [[] for _ in range(n)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        reverse_graph[b].append(a)
    
    stack = []
    visited = [0]*n

    for i in range(n):
        if not visited[i]:
            dfs(i, visited, stack)
    
    result = [[] for _ in range(n)]
    visited = [0]*n
    idx = -1
    ids = [-1]*n

    while stack:
        scc = []
        node = stack.pop()
        if not visited[node]:
            idx += 1
            reverse_dfs(node, visited, scc)
            result[idx] = scc
    scc_indegree = [0]*(idx+1)

    for i in range(n):
        for ed in graph[i]:
            if ids[i] != ids[ed]:
                scc_indegree[ids[ed]] += 1

    cnt = 0
    tmp = []
    for i in range(idx+1):
        if scc_indegree[i] == 0:
            for r in result[i]:
                tmp.append(r)
            cnt += 1
    
    if cnt == 1:
        print(*sorted(tmp), sep='\n')
    else:
        print("Confused")
    
    line = input()
    print()
