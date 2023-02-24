import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**9)

def dfs(idx, cur):
    plus[idx] += cur

    for g in graph[idx]:
        dfs(g, plus[idx])


N, M = map(int, input().split())

boss = list(map(int, input().split()))
graph = [[] for _ in range(N)]

for i in range(N):
    if boss[i] != -1:
        graph[boss[i]-1].append(i)

plus = [0]*N
for _ in range(M):
    a, b = map(int, input().split())
    plus[a-1] += b

dfs(0, 0)
print(*plus)
