import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(x):
    global leaf
    visited[x] = True
    q = deque()
    q.append(x)
    while q:
        n = q.popleft()
        if len(graph[n]) == 1 and visited[graph[n][0]]:
            leaf += 1
        for i in graph[n]:
            if not visited[i]:
                visited[i] = True
                q.append(i)


n, w = map(int, input().split())
visited = [False] * (n+1)
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

leaf = 0
bfs(1)
print(w/leaf)
