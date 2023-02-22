import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(start):
    visited = [-1]*(n+1)
    visited[start] = 0
    q = deque([start])
    while q:
        cur = q.popleft()
        for nxt, cost in graph[cur]:
            if visited[nxt] == -1:
                q.append(nxt)
                visited[nxt] = visited[cur] + cost
    
    m = max(visited)
    return [visited.index(m), m]


n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b, w = map(int, input().split())
    graph[a].append((b, w))
    graph[b].append((a, w))

print(bfs(bfs(1)[0])[1])
