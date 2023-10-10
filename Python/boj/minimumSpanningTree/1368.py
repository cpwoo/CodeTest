import sys
input = lambda: sys.stdin.readline().rstrip()

from heapq import *
        
def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]
    
def union(a, b):
    a, b = find(a), find(b)
    if a == b: return False
    else:
        parents[b] = a
        return True


n = int(input())
q = []
parents = list(range(n+1))

for i in range(1, n+1):
    heappush(q, (int(input()), 0, i))
    
for i in range(1, n+1):
    line = list(map(int, input().split()))
    for j in range(1, n+1):
        if i == j: continue
        heappush(q, (line[j-1], i, j))

total = 0
while q:
    cur_cost, node1, node2 = heappop(q)
    if union(node1, node2):
        total += cur_cost
        
print(total)
