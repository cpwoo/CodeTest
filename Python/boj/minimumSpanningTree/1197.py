import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


V, S = map(int, input().split())

edge = []
for _ in range(S):
    a, b, w = map(int, input().split())
    edge.append((w, a, b))

edge.sort(key=lambda x: x[0])

parent = list(range(V+1))

total = 0
for w, s, e in edge:
    if find(s) != find(e):
        union(s, e)
        total += w

print(total)
