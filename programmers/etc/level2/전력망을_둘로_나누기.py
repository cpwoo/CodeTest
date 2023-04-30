from collections import deque

def solution(n, wires):
    answer = 101
    graph = [[] for _ in range(n+1)]
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    def bfs(node, visited, graph):
        q = deque([node])
        visited[node] = True
        res = 1
        while q:
            cur = q.popleft()
            for nxt in graph[cur]:
                if not visited[nxt]:
                    visited[nxt] = True
                    res += 1
                    q.append(nxt)
        return res
    
    for a, b in wires:
        visited = [False]*(n+1)
        visited[b] = True
        res = bfs(a, visited, graph)
        answer = min(answer, abs(res-(n-res)))
    
    return answer


n = 9
wires = [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
print(solution(n, wires)) # 3

n = 4
wires = [[1,2],[2,3],[3,4]]
print(solution(n, wires)) # 0

n = 7
wires = [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]
print(solution(n, wires)) # 1
