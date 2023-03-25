import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def init(node, start, end):
    if start == end:
        tree_min[node] = arr[start]
        return tree_min[node]
    
    mid = (start+end)//2
    tree_min[node] = min(init(node*2, start, mid), init(node*2+1, mid+1, end))
    return tree_min[node]

def query(node, start, end, left, right):
    if start > right or end < left:
        return int(1e9)
    if left <= start and end <= right:
        return tree_min[node]

    mid = (start+end)//2
    return min(query(node*2, start, mid, left, right), query(node*2+1, mid+1, end, left, right))

n, m = map(int, input().split())
arr = [int(input()) for _ in range(n)]
h = int(ceil(log2(n)))
t_size = 1 << (h+1)

tree_min = [0] * t_size

init(1, 0, n-1)

for _ in range(m):
    a, b = map(int, input().split())
    print(query(1, 0, n-1, a-1, b-1))
