import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(x):
    count[x] = 1
    for i in tree[x]:
        if not count[i]:
            dfs(i)
            count[x] += count[i]


n, r, q = map(int, input().split())
tree = [[] for _ in range(n+1)]
count = [0]*(n+1)

for _ in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

dfs(r)

for _ in range(q):
    print(count[int(input())])
