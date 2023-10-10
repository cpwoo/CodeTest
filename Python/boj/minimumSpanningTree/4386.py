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
stars = [list(map(float, input().split())) for _ in range(n)]
dist = []

for i in range(n-1):
    for j in range(i+1, n):
        dist.append([((stars[i][0]-stars[j][0])**2+(stars[i][1]-stars[j][1])**2)**0.5, i, j])

dist.sort()

answer = 0
parent = list(range(n))

for d, a, b in dist:
    if find(a) != find(b):
        union(a, b)
        answer += d

print("%.2f" %answer)
