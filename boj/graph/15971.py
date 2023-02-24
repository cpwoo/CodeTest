import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n, start, end = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

visited = [False]*(n+1)
q = deque()
q.append([start, 0, 0])
visited[start] = True
while q:
    now, total, _max = q.popleft()
    if now == end:
        print(total-_max)
        break
    for nxt, cost in graph[now]:
        if not visited[nxt]:
            visited[nxt] = True
            q.append([nxt, total+cost, max(_max, cost)])
