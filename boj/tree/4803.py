import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(prev, node):
    visited[node] = True
    for i in graph[node]:
        if i == prev:
            continue
        if visited[i]:
            return False
        if not dfs(node, i):
            return False
    return True


T = 0
while True:
    T += 1
    N, M = map(int, input().split())
    if (N, M) == (0, 0):
        break
    graph = [[] for _ in range(N+1)]
    visited = [False]*(N+1)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    cnt = 0
    for i in range(1, N+1):
        if not visited[i]:
            if dfs(0, i):
                cnt += 1
    
    if cnt == 0:
        print("Case {}: No trees.".format(T))
    elif cnt == 1:
        print("Case {}: There is one tree.".format(T))
    else:
        print("Case {}: A forest of {} trees.".format(T, cnt))
