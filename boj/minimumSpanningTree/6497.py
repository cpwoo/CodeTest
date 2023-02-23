import sys
input = lambda: sys.stdin.readline().rstrip()

def find(a):
    if a != parent[a]:
        parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


while True:
    m, n = map(int, input().split())
    if (m, n) == (0, 0):
        break
    edge = []
    parent = list(range(m+1))
    ans = 0

    for _ in range(n):
        x, y, z = map(int, input().split())
        edge.append([z, x, y])
    
    edge.sort()

    for e in edge:
        z, x, y = e
        if find(x) != find(y):
            union(x, y)
        else:
            ans += z
    print(ans)
