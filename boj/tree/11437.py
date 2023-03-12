import sys
input = lambda: sys.stdin.readline().rstrip()

# 트리 깊이를 2^i만큼 뛰어다니면서 시간 단축

def dfs(x, depth):
    visited[x] = True
    d[x] = depth
    for node in graph[x]:
        if visited[node]: continue
        # 바로 위에 있는 부모 정보 갱신
        parent[node][0] = x
        dfs(node, depth+1)

# 모든 노드의 전체 부모 관계 갱신
def set_parent():
    dfs(1, 0)
    for i in range(1, 21):
        for j in range(1, n+1):
            parent[j][i] = parent[parent[j][i-1]][i-1]

def lca(a, b):

    if d[a] > d[b]:
        a, b = b, a
    
    for i in range(21-1, -1, -1):
        if d[b] - d[a] >= 2**i:
            b = parent[b][i]

    if a == b:
        return a

    for i in range(21-1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    return parent[a][0]


n = int(input())
parent = [[0]*21 for _ in range(n+1)] # 2^20 = 1048576
visited = [False] * (n+1)
d = [0] * (n+1)
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

set_parent()

for _ in range(int(input())):
    a, b = map(int, input().split())
    print(lca(a, b))
