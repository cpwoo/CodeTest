import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if a > b:
        a, b = b, a
    if a != b:
        power[a] = power[a]+power[b]+nadori[a]*nadori[b]
        nadori[a] = nadori[a]+nadori[b]
    parent[b] = a
    return power[a]


n, q = map(int, input().split())
parent = list(range(n))
nadori = list(map(int, input().split()))
power = [0]*n

for _ in range(q):
    a, b = map(lambda x: int(x)-1, input().split())
    print(union(a, b))
