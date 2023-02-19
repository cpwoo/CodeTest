import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**8)

def dfs(idx, depth):
    global flag
    visited[idx] = True
    if depth == 4:
        flag = True
        return
    for i in graph[idx]:
        if not visited[i]:
            visited[i] = True
            dfs(i, depth+1)
            visited[i] = False


n, m = map(int, input().split())
graph = [[] for _ in range(n)]
visited = [False]*2001
flag = False

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n):
    dfs(i, 0)
    visited[i] = False
    if flag:
        break

print(1 if flag else 0)
