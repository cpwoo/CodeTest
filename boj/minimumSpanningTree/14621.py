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
gender = list(input().split())
parent = list(range(n+1))
path_sum = 0
path_num = 0

edges = []
for _ in range(m):
    u, v, d = map(int, input().split())
    edges.append([d, u, v])

edges.sort()

for edge in edges:
    cost, a, b = edge
    if find(a) != find(b) and gender[a-1] != gender[b-1]:
        union(a, b)
        path_sum += cost
        path_num += 1

print(path_sum if path_num == n-1 else -1)
