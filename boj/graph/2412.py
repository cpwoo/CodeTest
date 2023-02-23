import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque, defaultdict

def bfs():
    q = deque()
    q.append((0, 0, 0))
    while q:
        x, y, cnt = q.popleft()
        if y == T:
            return cnt
        for nx in range(x-2, x+3):
            for ny in range(y-2, y+3):
                if nx<0 or ny<0: continue
                if ny in visited[nx]:
                    visited[nx].remove(ny)
                    q.append((nx, ny, cnt+1))
    return -1


n, T = map(int, input().split())
visited = defaultdict(list)

for _ in range(n):
    x, y = map(int, input().split())
    visited[x].append(y)

print(bfs())
