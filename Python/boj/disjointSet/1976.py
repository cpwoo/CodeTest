import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)

n, m = int(input()), int(input())
parent = list(range(n+1))

for y in range(1, n+1):
    maps = list(map(int, input().split()))
    for x in range(1, len(maps)+1):
        if maps[x-1] == 1:
            union(y, x)

tour = list(map(int, input().split()))
result = set([find(t) for t in tour])

print("YES" if len(result) == 1 else "NO")
