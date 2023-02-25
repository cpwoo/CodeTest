import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**9)

def dfs(u,p,s,f):
    if f == 0:
        ans[0] = s
    else:
        ans[1] = max(ans[1], s) 

    if f == 0 and len(graph[u]) > 2-int(u==r): 
        f, s = 1, 0
    for v, w in graph[u]:
        if v == p: continue
        dfs(v,u,s+w,f)


n, r = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

ans = [0, 0]

dfs(r,r,0,0)

print(ans[0],ans[1])
