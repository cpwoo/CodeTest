import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

N, Q = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

for _ in range(Q):
    K, V = map(int, input().split())
    q = deque()
    q.append(V)
    visited = [False]*(N+1)
    visited[V] = True
    cnt = 0
    while q:
        cur = q.popleft()
        for nxt, cost in graph[cur]:
            if not visited[nxt]:
                if cost >= K:
                    q.append(nxt)
                    cnt += 1
                    visited[nxt] = True
    print(cnt)
