import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x, y = find(x), find(y)
    parent[max(x, y)] = min(x, y)


n = int(input())
c = []
for i in range(n):
    x, y, z = map(int, input().split())
    c.append([x, y, z, i])

edges = []
for i in range(3):
    c.sort(key=lambda x:x[i])
    for j in range(1, n):
        edges.append([abs(c[j-1][i]-c[j][i]), c[j-1][3], c[j][3]])

parent = list(range(n))
total = 0
edges.sort()

for i in range(len(edges)):
    if find(edges[i][1]) != find(edges[i][2]):
        union(edges[i][1], edges[i][2])
        total += edges[i][0]

print(total)
