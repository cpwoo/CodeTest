import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x, parent):
    if parent[x] != x:
        parent[x] = find(parent[x], parent)
    return parent[x]

def union(a, b, parent):
    a, b = find(a, parent), find(b, parent)
    parent[max(a, b)] = min(a, b)


n, m = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(m+1)]

worst, best = 0, n
max_parent, min_parent = list(range(n+1)), list(range(n+1))

for u, v, w in edges:
    if w == 1:
        u, v = find(u, min_parent), find(v, min_parent)
        if u != v:
            best -= 1
            union(u, v, min_parent)
    else:
        u, v = find(u, max_parent), find(v, max_parent)
        if u != v:
            worst += 1
            union(u, v, max_parent)

print(worst**2 - best**2)
