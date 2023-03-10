import sys
input = lambda: sys.stdin.readline().rstrip()

def dist(i, j):
    i1, j1, i2, j2 = i[0], i[1], j[0], j[1]
    return ((i1-i2)**2 + (j1-j2)**2)**0.5

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)

n, m = map(int, input().split())
parent = list(range(n+1))

edges = [0]*(n+1)
for i in range(1, n+1):
    edges[i] = list(map(int, input().split()))
    
for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)

case = []
for i in range(1, n):
    for j in range(i+1, n+1):
        case.append([dist(edges[i], edges[j]), i, j])

case.sort()
ans = 0

for c in case:
    cost, x, y = c[0], c[1], c[2]

    if find(x) != find(y):
        union(x, y)
        ans += cost

print("%.2f" %ans)
