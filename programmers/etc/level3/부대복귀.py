from collections import deque

def solution(n, roads, sources, destination):
    graph = [[] for _ in range(n+1)]
    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)
        
    visited = [-1]*(n+1)
    visited[destination] = 0

    q = deque([destination])
    
    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if visited[nxt] == -1:
                visited[nxt] = visited[cur]+1
                q.append(nxt)
    
    return [visited[s] for s in sources]


n = 3
roads = [[1, 2], [2, 3]]
sources = [2, 3]
destination = 1
print(solution(n, roads, sources, destination)) # [1, 2]

n = 5
roads = [[1, 2], [1, 4], [2, 4], [2, 5], [4, 5]]
sources = [1, 3, 5]
destination = 5
print(solution(n, roads, sources, destination)) # [2, -1, 0]
