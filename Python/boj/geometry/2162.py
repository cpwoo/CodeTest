import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)

def ccw(x1, y1, x2, y2, x3, y3):
    c = (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1)
    return 0 if c == 0 else c // abs(c)

def check(x1, y1, x2, y2, x3, y3, x4, y4):
    ccw1 = ccw(x1, y1, x2, y2, x3, y3)
    ccw2 = ccw(x1, y1, x2, y2, x4, y4)
    ccw3 = ccw(x3, y3, x4, y4, x1, y1)
    ccw4 = ccw(x3, y3, x4, y4, x2, y2)
     
    if ccw1 * ccw2 == 0 and ccw3 * ccw4 == 0:
        if min(x1, x2) <= max(x3, x4) and max(x1, x2) >= min(x3, x4) and min(y1, y2) <= max(y3, y4) and min(y3, y4) <= max(y1, y2):
            return 1
    elif ccw1 * ccw2 <= 0 and ccw3 * ccw4 <= 0:
        return 1
    return 0


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
parent = list(range(n))

for i in range(n):
    for j in range(i+1, n):
        if check(*arr[i], *arr[j]):
            union(i, j)

for i in range(n):
    parent[i] = find(parent[i])
d = {}
for p in parent:
    d[p] = d.get(p, 0) + 1

print(len(d.values()))
print(max(d.values()))
