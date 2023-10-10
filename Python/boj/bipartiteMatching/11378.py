import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(start):
    if visited[start]: return 0
    visited[start] = 1
    for i in graph[start]:
        if d[i] == 0 or dfs(d[i]):
            d[i] = start
            return 1
    return 0


n, m, k = map(int, input().split())
graph = [[] for _ in range(n+1)]
d = [0]*(m+1)
cnt = 0

for i in range(1, n+1):
    arr = list(map(int, input().split()))
    for j in arr[1:]:
        graph[i].append(j)

for i in range(1, n+1):
    visited = [0]*(n+1)
    cnt += dfs(i)

for i in range(1, n+1):
    while k > 0:
        visited = [0]*(n+1)
        if dfs(i):
            k -= 1
            cnt += 1
        else:
            break

print(cnt)
