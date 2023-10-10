import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)

    if a < b:
        parent[b] = a
        set_size[a] += set_size[b]
        set_size[b] = 0
    elif b < a:
        parent[a] = b
        set_size[b] += set_size[a]
        set_size[a] = 0


N = int(input())
cmd = [list(input().split()) for _ in range(N)]
M = 1_000_000
parent = list(range(M+1))
set_size = [1]*(M+1)

for query in cmd:
    if query[0] == 'I':
        union(int(query[1]), int(query[2]))
    elif query[0] == 'Q':
        c = int(query[1])
        print(set_size[find(c)])
