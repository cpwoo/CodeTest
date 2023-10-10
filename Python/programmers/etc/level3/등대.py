import sys
sys.setrecursionlimit(10**6)

def solution(n, lighthouse):
    
    def dfs(node):
        visited[node] = 1
        if not graph[node]:
            return 1, 0
        on, off = 1, 0
        for nxt in graph[node]:
            if not visited[nxt]:
                child_on, child_off = dfs(nxt)
                on += min(child_on, child_off)
                off += child_on
        return on, off
    
    graph = [[] for _ in range(n+1)]
    for u, v in lighthouse:
        graph[u].append(v)
        graph[v].append(u)
    visited = [0]*(n+1)
    
    on, off = dfs(1)
    
    return min(on, off)


n = 8
lighthouse = [[1, 2], [1, 3], [1, 4], [1, 5], [5, 6], [5, 7], [5, 8]]
print(solution(n, lighthouse)) # 2

n = 10
lighthouse = [[4, 1], [5, 1], [5, 6], [7, 6], [1, 2], [1, 3], [6, 8], [2, 9], [9, 10]]
print(solution(n, lighthouse)) # 3
