import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

INF = int(1e9)

n, m = int(input()), int(input())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])

start, end = map(int, input().split())

nearnest = [start]*(n+1)
distance = [INF]*(n+1)

q = []
heappush(q, [0, start])
while q:
    dist, now = heappop(q)
    if distance[now] < dist:
        continue

    for i in graph[now]:
        cost = dist + i[1]
        if cost < distance[i[0]]:
            distance[i[0]], nearnest[i[0]] = cost, now
            heappush(q, [cost, i[0]])

answer = []
tmp = end
while True:
    answer.append(tmp)
    if tmp == start:
        break
    tmp = nearnest[tmp]

answer = answer[::-1]

print(distance[end])
print(len(answer))
print(*answer)
