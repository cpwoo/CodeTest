import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n, m = map(int, input().split())
parent = list(range(n+1))

edges = []

for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append([c, a, b])

edges.sort()

result = []
for edge in edges:
    cost, a, b = edge

    if find(a) != find(b):
        union(a, b)
        result.append(cost)

# 마을 두개 분리
print(sum(result[:-1]))
