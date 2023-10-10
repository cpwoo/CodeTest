import sys
def input(): return sys.stdin.readline().rstrip()

from collections import deque

def bfs(m):
    q = deque()
    q.append(start)
    visited = set()
    visited.add(start)
    while q:
        x = q.popleft()
        for y, w in graph[x]:
            if y not in visited and w >= m:
                visited.add(y)
                q.append(y)
    return True if end in visited else False


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, w = map(int, input().split())
    graph[a].append([b, w])
    graph[b].append([a, w])

start, end = map(int, input().split())

_min, _max = 1, int(1e9)

result = 1
while _min <= _max:
    mid = (_min + _max)//2
    if bfs(mid):
        result = mid
        _min = mid+1
    else:
        _max = mid-1

print(result)
