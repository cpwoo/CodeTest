import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(v):
    q = deque([v])
    visited[v] = 1

    while q:
        target = q.popleft()
        for i in range(1, 7):
            dice = target + i
            if dice > 100:
                continue
            cnt = graph[dice]
            if visited[cnt] == 0:
                q.append(cnt)
                visited[cnt] = visited[target] + 1
                if cnt == 100:
                    return


n, m = map(int, input().split())
graph = list(range(101))

for _ in range(n+m):
    a, b = map(int, input().split())
    graph[a] = b

visited = [0] * 101
bfs(1)

print(visited[100]-1)
