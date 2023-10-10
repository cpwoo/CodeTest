import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**9)

def dfs(start, group):
    global check

    if check: return
    
    visited[start] = group

    for i in graph[start]:
        if not visited[i]:
            dfs(i, -group)
        elif visited[start] == visited[i]:
            check = True
            return


for _ in range(int(input())):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V+1)]
    visited = [False] * (V+1)
    check = False

    for _ in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    for i in range(1, V+1):
        if not visited[i]:
            dfs(i, 1)
            if check:
                break
    
    print('NO' if check else 'YES')
