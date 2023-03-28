import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**5)

LOG = 21

def find_depth(cur_node, parent_node):
    depth[cur_node] = depth[parent_node]+1
    check[cur_node] = True
    for nxt_node in graph[cur_node]:
        if not check[nxt_node]:
            parent[nxt_node][0] = cur_node
            find_depth(nxt_node, cur_node)

def LCA(a, b):
    if depth[a] > depth[b]:
        a, b = b, a
    for i in range(LOG-1, -1, -1):
        if depth[b] - depth[a] >= (1<<i):
            b = parent[b][i]
    if a==b:
        return a
    for i in range(LOG-1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    return parent[a][0]

def set_parent():
    find_depth(1, 0)
    for i in range(1, LOG):
        for j in range(1, n+1):
            parent[j][i] = parent[parent[j][i-1]][i-1]


n = int(input())
parent = [[0]*LOG for _ in range(n+1)]
depth = [0]*(n+1)
check = [False]*(n+1)

graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

depth[0] = -1

set_parent()

for _ in range(int(input())):
    a, b = map(int, input().split())
    print(LCA(a, b))
