import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n, m, t = map(int, input().split())
arr = sorted([list(map(int, input().split())) for _ in range(m)], key=lambda t: t[2])
parent = list(range(n+1))

cost = 0
for u, v, w in arr:
    if find(u) != find(v):
        union(u, v)
        cost += w

print(cost+(t*(n-2)*(n-1)//2))
