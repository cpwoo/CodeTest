import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


for i in range(int(input())):
    n, k = int(input()), int(input())
    parent = list(range(n))

    for _ in range(k):
        a, b = map(int, input().split())
        if find(a) != find(b):
            union(a, b)
    
    ret = []
    for _ in range(int(input())):
        a, b = map(int, input().split())
        ret.append(1 if find(a) == find(b) else 0)
    
    print(f"Scenario {i+1}:")
    print(*ret, sep='\n')
    print()
