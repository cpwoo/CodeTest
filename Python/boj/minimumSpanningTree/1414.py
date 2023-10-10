import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n = int(input())
data = [list(input()) for _ in range(n)]
parent = list(range(n+1))
graph = []

tot = 0
for i in range(n):
    for j in range(n):
        if data[i][j] == 0:
            graph.append((0, i+1, j+1))
        else:
            x = ord(data[i][j])
            if ord("a") <= x <= ord("z"):
                graph.append((x-ord("a")+1, i+1, j+1))
                tot += x-ord("a")+1
            elif ord("A") <= x <= ord("Z"):
                graph.append((x-ord("A")+27, i+1, j+1))
                tot += x-ord("A")+27

graph.sort()
for L, A, B in graph:
    if L == 0:
        continue
    if find(A) != find(B):
        union(A, B)
        tot -= L
    else:
        continue

chk = True
for i in range(1, n+1):
    if find(i) != 1:
        chk = False
        break

print(tot if chk else -1)
