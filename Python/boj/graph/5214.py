import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n, k, m = map(int, input().split())

graph = [[] for _ in range(n+m+1)]

for i in range(1, m+1):
    sub = list(map(int, input().split()))
    graph[n+i] = sub
    for s in sub:
        graph[s].append(n+i)

visited = [False]*(n+m+1)

q = deque()
q.append([1, visited, 1])
visited[1] = True

while q:
    subway, visited, level = q.popleft()
    if subway == n:
        print(level)
        exit()

    for s in graph[subway]:
        if not visited[s]:
            visited[s] = True
            if s > n:
                q.append([s, visited, level])
            else:
                q.append([s, visited, level+1])

print(-1)
