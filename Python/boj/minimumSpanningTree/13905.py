import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

INF = sys.maxsize

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n, m = map(int, input().split())
s, e = map(int, input().split())

infos = sorted([list(map(int, input().split())) for _ in range(m)], key=lambda t: -t[2])
parent = list(range(n+1))

graph = [[] for _ in range(n+1)]
for u, v, w in infos:
    if find(u) != find(v):
        union(u, v)
        graph[u].append((v, w))
        graph[v].append((u, w))

visited = [INF]*(n+1)
q = deque()
q.append(s)
while q:
    cur_node = q.popleft()
    if cur_node == e:
        break
    for nxt_node, cost in graph[cur_node]:
        if visited[nxt_node] == INF:
            visited[nxt_node] = min(visited[cur_node], cost)
            q.append(nxt_node)

print(visited[e] if visited[e] != INF else 0)
