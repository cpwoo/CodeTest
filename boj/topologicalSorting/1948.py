import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

N, M = int(input()), int(input())

time = [0]*(N+1)
in_degree = [0]*(N+1)
graph = [[] for _ in range(N+1)]
cnt = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    in_degree[b] += 1

start, end = map(int, input().split())

q = deque([start])

while q:
    now = q.popleft()
    for i in graph[now]:
        in_degree[i[1]] -= 1
        if time[i[1]] < time[now] + i[0]:
            time[i[1]] = time[now] + i[0]
            cnt[i[1]] = [now]
        elif time[i[1]] == time[now] + i[0]:
            cnt[i[1]].append(now)
          
        if in_degree[i[1]] == 0:
            q.append(i[1])

q = deque([end])
route = set()
while q:
    now = q.popleft()
    for x in cnt[now]:
        if (now, x) not in route:
            route.add((now, x))
            q.append(x)

print(time[end])
print(len(route))
