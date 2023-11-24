import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(cur, bef):
    parentWeight = 0
    childWeight = 0

    for nxt, weight in graph[cur]:
        if nxt == bef:
            parentWeight = weight
            continue
        if not visited[nxt]:
            visited[nxt] = True
            childWeight += dfs(nxt, cur)
    
    if len(graph[cur]) == 1:
        return parentWeight
    
    return min(parentWeight, childWeight)


for _ in range(int(input())):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    visited = [False]*(n+1)
    
    for _ in range(m):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
        graph[v].append((u, w))
    
    ret = 0
    for nxt, weight in graph[1]:
        ret += dfs(nxt, 1)

    print(ret)
