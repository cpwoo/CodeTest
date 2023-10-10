import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]
    
def union(a, b):
    a, b = find(a), find(b)
    parents[max(a,b)] = min(a,b)
    return False if a == b else True


n, m = map(int, input().split())
q = []
parents = list(range(n+1))
total = 0
for _ in range(m):
    a, b, c = map(int, input().split())
    total += c
    heappush(q, [c, a, b])

MST = 0
edge_cnt = 0
while q:
    cur_cost, node1, node2 = heappop(q)
    if union(node1, node2):
        MST += cur_cost
        edge_cnt += 1
        if edge_cnt == n-1:
            break

print(total-MST if edge_cnt == n-1 else -1)
