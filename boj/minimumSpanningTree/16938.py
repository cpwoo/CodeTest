import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n = int(input())
parent = list(range(n))
graph = [list(map(int, input().split())) for _ in range(n)]
edges = []

for a in range(n):
    for b in range(a+1, n):
        edges.append([graph[a][b], a, b])
        
edges.sort()

result = 0

for edge in edges:
    cost, a, b = edge    
    if find(a) != find(b):
        union(a, b)
        result += cost
        
print(result)
