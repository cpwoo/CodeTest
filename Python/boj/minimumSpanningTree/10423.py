import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


N, M, K = map(int, input().split())
arr = list(map(int, input().split()))

parent = list(range(N+1))
for a in arr:
    parent[a] = 0

graph = [list(map(int, input().split())) for _ in range(M)]
graph.sort(key=lambda t: t[2])

answer = 0
for u, v, w in graph:
    if find(u) != find(v):
        union(u, v)
        answer += w

print(answer)
