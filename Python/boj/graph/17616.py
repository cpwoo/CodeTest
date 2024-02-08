import sys
input = lambda : sys.stdin.readline().rstrip()

from collections import deque

def search(x, graph):
    cnt = 0
    q = deque()
    q.append(x)
    visited = [False]*(N+1)
    visited[x] = True

    while q:
        cur = q.popleft()
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = True
                q.append(nxt)
                cnt += 1
    
    return cnt


N, M, X = map(int, input().split())

parent = [[] for _ in range(N+1)]
child = [[] for _ in range(N+1)]

for _ in range(M):
    u, v = map(int, input().split())
    parent[v].append(u)
    child[u].append(v)

print(1+search(X, parent), N-search(X, child))
