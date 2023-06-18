import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a,b)] = min(a,b)


n = int(input())
parent = list(range(n+1))

for _ in range(n-2):
    a, b = map(int, input().split())
    union(a, b)

answer = []
for i in range(1, n+1):
    if i == parent[i]:
        answer.append(i)

print(*answer)
