import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

def dfs(cur):
    visited[cur] = True
    for nxt, p, q in graph[cur]:
        if not visited[nxt]:
            ratio[nxt] = ratio[cur]*q//p
            dfs(nxt)


n = int(input())
graph = [[] for _ in range(n)]
visited = [False]*n
ratio = [0]*n

lcm = 1
for _ in range(n-1):
    a, b, p, q = map(int, input().split())
    graph[a].append((b,p,q))
    graph[b].append((a,q,p))
    lcm *= (p*q)//gcd(p,q)

ratio[0] = lcm
dfs(0)
m = ratio[0]

for i in range(1, n):
    m = gcd(m, ratio[i])

print(*[ratio[i]//m for i in range(n)])
