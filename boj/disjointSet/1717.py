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


n, m = map(int, input().split())
parent = list(range(n+1))

for _ in range(m):
    q, a, b = map(int, input().split())
    if q == 0:
        union(a, b)
    elif q == 1:
        print("YES" if find(a) == find(b) else "NO")
