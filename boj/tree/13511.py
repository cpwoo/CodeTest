import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque
from math import ceil, log2

n = int(input())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b, c = map(int, input().split())
    tree[a].append((b, c))
    tree[b].append((a, c))

# 트리의 각 node마다 depth, 부모, 부모와의 거리 계산
parent = [[0, 0] for _ in range(n+1)]
depth = [0]*(n+1)
visited = [False]*(n+1)
q = deque([1])
visited[1] = True

while q:
    cur = q.popleft()
    for nxt, cost in tree[cur]:
        if not visited[nxt]:
            q.append(nxt)
            parent[nxt][0] = cur
            parent[nxt][1] = cost
            depth[nxt] = depth[cur]+1
            visited[nxt] = True

# 희소 테이블 생성
h = ceil(log2(n))
dp = [[[0, 0] for _ in range(h)] for _ in range(n+1)]

for i in range(n+1):
    dp[i][0][0] = parent[i][0]
    dp[i][0][1] = parent[i][1]

for j in range(1, h):
    for i in range(1, n+1):
        dp[i][j][0] = dp[dp[i][j-1][0]][j-1][0]
        dp[i][j][1] = dp[i][j-1][1] + dp[dp[i][j-1][0]][j-1][1]

for _ in range(int(input())):
    query = list(map(int, input().split()))
    u, v = query[1], query[2]
    # 미리 1<<i 만큼 뛰면서 lca 찾아주기
    if depth[u] < depth[v]:
        u, v = v, u
    diff = depth[u]-depth[v]
    for i in range(h):
        if diff & (1<<i):
            u = dp[u][i][0]
    if u == v:
        lca = u
    else:
        for i in range(h-1, -1, -1):
            if dp[u][i][0] != dp[v][i][0]:
                u, v = dp[u][i][0], dp[v][i][0]
        lca = dp[u][0][0]

    # u, v 값이 변경되었으니 원래 값으로 reset
    cmd, u, v = query[0], query[1], query[2]
    if cmd == 1:
        cost = 0
        diff_u = depth[u]-depth[lca]
        diff_v = depth[v]-depth[lca]
        for i in range(h):
            if diff_u & (1<<i):
                cost += dp[u][i][1]
                u = dp[u][i][0]
            if diff_v & (1<<i):
                cost += dp[v][i][1]    
                v = dp[v][i][0]
        print(cost)
    else:
        # k번째 정점이 u와 lca 사이에 있는지 아닌지 구분하여 출력
        k = query[3]
        if k <= depth[u]-depth[lca]:
            diff = k-1
            for i in range(h):
                if diff & (1<<i):
                    u = dp[u][i][0]
            print(u)
        else:
            diff = depth[u]+depth[v]-2*depth[lca]-k+1
            for i in range(h-1, -1, -1):
                if diff & (1<<i):
                    v = dp[v][i][0]
            print(v)
