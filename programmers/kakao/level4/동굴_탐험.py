def solution(n, path, order):
    graph = [[] for _ in range(n)]
    for a, b in path:
        graph[a].append(b)
        graph[b].append(a)
        
    pre = [0]*n
    for a, b in order:
        pre[b] = a
    post = [0]*n
    
    visited = [False]*n

    def dfs(node):
        stack = [node]
        visited[node] = True
        while stack:
            cur = stack.pop()
            for nxt in graph[cur]:
                if post[cur]:
                    dfs(post[cur])
                if not visited[pre[cur]]:
                    post[pre[cur]] = cur
                    continue
                if not visited[nxt]:
                    stack.append(nxt)
                    visited[nxt] = True
    dfs(0)

    return sum(visited) == n


n = 9
path = [[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]
order = [[8,5],[6,7],[4,1]]
print(solution(n, path, order)) # True

n = 9
path =[[8,1],[0,1],[1,2],[0,7],[4,7],[0,3],[7,5],[3,6]]
order = [[4,1],[5,2]]
print(solution(n, path, order)) # True

n = 9
path = [[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]
order = [[4,1],[8,7],[6,5]]
print(solution(n, path, order)) # False
