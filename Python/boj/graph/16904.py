import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(d, cur):
    visited[cur] = 1
    d.append(cur)

    for nxt in graph[cur]:
        if visited[nxt]: continue
        dfs(d, nxt)


n = int(input())

graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# dfs 순서 정하기 위해 graph 조정
ans = list(map(int, input().split()))
order = [0]*(n+1)
for i, a in enumerate(ans):
    order[a] = i

for i in range(1, n+1):
    graph[i].sort(key=lambda t: order[t])

# dfs 판단
visited = [0]*(n+1)
d = []
dfs(d, 1)

print(1 if d == ans else 0)
