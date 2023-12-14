import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(200000)

def dfs(cur):
    ret = 0
    for nxt in graph[cur]:
        ret += dfs(nxt)
    if kind[cur] == "S" and cur != 1:
        ret += cnts[cur]
    elif kind[cur] == "W":
        ret = max(0, ret-cnts[cur])
    return ret

n = int(input())

kind = ["S"]*(n+1)
cnts = [0]*(n+1)
graph = [[] for _ in range(n+1)]

for i in range(2, n+1):
    state, cnt, parent = input().split()
    kind[i] = state
    cnts[i] = int(cnt)
    graph[int(parent)].append(i)

print(dfs(1))
