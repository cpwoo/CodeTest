import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def dfs(cur, cnt):
    visited[cur] = cnt

    child = 0
    ret = visited[cur]

    for nxt in graph[cur]:
        if visited[nxt]:
            ret = min(ret, visited[nxt])
        else:
            child += 1
            subTree = dfs(nxt, cnt+1)

            if cnt != 1 and subTree >= visited[cur]:
                cutVertex.add(cur)
            
            ret = min(ret, subTree)
    
    if cnt == 1 and child >= 2:
        cutVertex.add(cur)
    
    return ret


v, e = map(int, input().split())
graph = [[] for _ in range(v+1)]
cutVertex = set()
candidates = set()

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    candidates.add(a)
    candidates.add(b)

visited = [0]*(v+1)
cnt = 1

for vertex in candidates:
    if not visited[vertex]:
        dfs(vertex, 1)

print(len(cutVertex))
print(*sorted(list(cutVertex)))
