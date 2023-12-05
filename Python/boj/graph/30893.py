import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(200000)

def dfs(cur, visited, path):
    if cur == e:
        for p in path:
            ret.append(p)
        return
    
    for nxt in graph[cur]:
        if not visited[nxt]:
            visited[nxt] = True
            path.append(nxt)
            dfs(nxt, visited, path)
            visited[nxt] = False
            path.pop()

n, s, e = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False]*(n+1)
visited[s] = True

ret = []
dfs(s, visited, [s])

s = set(ret)
for i in range(1, len(ret)-1, 2):
    for nxt in graph[ret[i]]:
        if nxt not in s:
            print("Second")
            exit()
else:
    print("First")
