import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def update(node, start, end):
     if start <= p <= end:
          tree[node] += q
          if start != end:
               mid = (start+end)//2
               update(node*2, start, mid)
               update(node*2+1, mid+1, end)

def query(node, start, end):
     if q < start or end < p:
          return 0
     if p <= start and end <= q:
          return tree[node]
     mid = (start+end)//2
     return query(node*2, start, mid) + query(node*2+1, mid+1, end)


N, Q = map(int, input().split())
h_size = 1<<(ceil(log2(N))+1)
tree = [0]*h_size

for _ in range(Q):
     cmd, p, q = map(int, input().split())
     if cmd == 1:
          p -= 1
          update(1, 0, N-1)
     else:
          p -= 1; q -= 1
          print(query(1, 0, N-1))
