import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs():
    visited = [False]*(n+1)
    q = deque([1])
    visited[1] = True

    idx = 1
    while q:
        cur = q.popleft()
        can = []
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = True
                can.append(nxt)
        if sorted(ans[idx:idx+len(can)]) == sorted(can):
            for nxt in ans[idx:idx+len(can)]:
                q.append(nxt)
            idx += len(can)
        else:
            return 0
    return 1


n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

ans = list(map(int, input().split()))
if ans[0] == 1:
    print(bfs())
else:
    print(0)
