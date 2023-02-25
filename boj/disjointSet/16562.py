import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if graph[a] < graph[b]:
        parent[b] = a
    else:
        parent[a] = b


n, m, k = map(int, input().split())
parent = list(range(n+1))
graph = [0] + list(map(int, input().split()))

for _ in range(m):
    v, w = map(int, input().split())
    union(v, w)
        
friend = set()
cost = 0

for i in range(1, n+1):
    if find(i) not in friend:
        cost += graph[parent[i]]
        friend.add(parent[i])

print(cost if cost <= k else "Oh no")
