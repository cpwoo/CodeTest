import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n = int(input())
graph = [[] for _ in range(n+1)]
answer = [[0]*(n+1) for _ in range(n+1)]
degree = [0]*(n+1)

for _ in range(int(input())):
    a, b, c = map(int, input().split())
    graph[b].append([a, c])
    degree[a] += 1

q = deque()
for i in range(1, n+1):
    if degree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    for nxt, cost in graph[cur]:
        if answer[cur].count(0) == n+1:
            answer[nxt][cur] += cost
        else:
            for i in range(1, n+1):
                answer[nxt][i] += answer[cur][i]*cost
        degree[nxt] -= 1
        if degree[nxt] == 0:
            q.append(nxt)

for x in enumerate(answer[n]):
    if x[1] > 0:
        print(*x)
