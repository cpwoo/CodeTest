import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

INF = int(1e9)
sz = 128

def bfs(flow, source):
    q = deque()
    q.append(source)
    parent = [-1]*sz
    parent[source] = source
    while q:
        item = q.popleft()
        for i in range(sz):
            if parent[i] == -1 and capacity[item][i]-flow[item][i] > 0:
                q.append(i)
                parent[i] = item
    return parent

def maxFlow(source, sink):
    flow = [[0]*sz for _ in range(sz)]
    ret = 0
    while True:
        parent = bfs(flow, source)
        if parent[sink] == -1: return ret
        p = sink
        amount = INF
        while p != source:
            amount = min(amount, capacity[parent[p]][p]-flow[parent[p]][p])
            p = parent[p]
        ret += amount
        p = sink
        while p != source:
            flow[parent[p]][p] += amount
            flow[p][parent[p]] -= amount
            p = parent[p]


n = int(input())
capacity = [[0]*sz for _ in range(sz)]
for _ in range(n):
    p, q, c = input().split()
    p, q = map(ord, (p, q))
    c = int(c)
    capacity[p][q] += c
    capacity[q][p] += c

print(maxFlow(ord('A'), ord('Z')))
