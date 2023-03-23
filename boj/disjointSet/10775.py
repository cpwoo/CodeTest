import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

G, P = int(input()), int(input())
parent = list(range(G+1))
planes = [int(input()) for _ in range(P)]

answer = 0
for plane in planes:
    docking = find(plane)
    if docking == 0: break
    parent[docking] = parent[docking-1]
    answer += 1

print(answer)
