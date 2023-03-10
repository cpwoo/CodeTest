import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n = int(input())
indegree = [0]*(n+1)
times = [0]*(n+1)
dp = [0]*(n+1)
graph = [[] for _ in range(n+1)]

for i in range(1, n+1):
    tower = list(map(int, input().split()))
    times[i] = tower[0]
    if len(tower) > 2:
        for j in tower[1:-1]:
            graph[j].append(i)
            indegree[i] += 1

q = deque()
for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)
        dp[i] = times[i]

while q:
    now = q.popleft()
    for nxt in graph[now]:
        indegree[nxt] -= 1
        dp[nxt] = max(dp[nxt], dp[now]+times[nxt])
        if indegree[nxt] == 0:
            q.append(nxt)

for d in dp:
    if d != 0: print(d)
