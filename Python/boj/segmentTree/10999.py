import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

# Lazy Propagation

def init(idx, start, end):
     if start == end:
          tree[idx] = nums[start]
          return
     mid = (start+end)//2
     init(idx*2, start, mid)
     init(idx*2+1, mid+1, end)
     tree[idx] = tree[idx*2] + tree[idx*2+1]


def propagate(idx, start, end):
     if lazy[idx] != 0:
          tree[idx] += (end-start+1)*lazy[idx]

          if start != end:
               lazy[idx*2] += lazy[idx]
               lazy[idx*2+1] += lazy[idx]
          
          lazy[idx] = 0


def update(idx, start, end, left, right, value):
     propagate(idx, start, end)

     if right < start or end < left:
          return

     if left <= start and end <= right:
          tree[idx] += (end-start+1)*value

          if start != end:
               lazy[idx*2] += value
               lazy[idx*2+1] += value

          return

     mid = (start+end)//2
     update(idx*2, start, mid, left, right, value)
     update(idx*2+1, mid+1, end, left, right, value)
     tree[idx] = tree[idx*2] + tree[idx*2+1]


def query(idx, start, end, left, right):
     propagate(idx, start, end)

     if right < start or end < left:
          return 0
     
     if left <= start and end <= right:
          return tree[idx]
     
     mid = (start+end)//2
     return query(idx*2, start, mid, left, right) + query(idx*2+1, mid+1, end, left, right)


n, m, k = map(int, input().split())
nums = [-1] + [int(input()) for _ in range(n)]
length = 1 << ceil(log2(n)+1)
tree = [0]*length
lazy = [0]*length
init(1, 1, n)

for _ in range(m+k):
     cmd = list(map(int, input().split()))

     if cmd[0] == 1:
          update(1, 1, n, cmd[1], cmd[2], cmd[3])
     else:
          print(query(1, 1, n, cmd[1], cmd[2]))
