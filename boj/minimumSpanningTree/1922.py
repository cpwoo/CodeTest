import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n, m = int(input()), int(input())
parent = list(range(n+1))

edges = [list(map(int, input().split())) for _ in range(m)]
edges.sort(key=lambda t: t[2])

cost = 0
for a, b, w in edges:
    if find(a) != find(b):
        union(a, b)
        cost += w

print(cost)
