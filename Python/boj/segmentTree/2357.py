import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def initMin(node, start, end):
    if start == end:
        tree_min[node] = arr[start]
        return tree_min[node]
    
    mid = (start+end)//2
    tree_min[node] = min(initMin(node*2, start, mid), initMin(node*2+1, mid+1, end))
    return tree_min[node]

def initMax(node, start, end):
    if start == end:
        tree_max[node] = arr[start]
        return tree_max[node]

    mid = (start+end)//2
    tree_max[node] = max(initMax(node*2, start, mid), initMax(node*2+1, mid+1, end))
    return tree_max[node]

def queryMin(node, start, end, left, right):
    if start > right or end < left:
        return int(1e9)
    if left <= start and end <= right:
        return tree_min[node]

    mid = (start+end)//2
    return min(queryMin(node*2, start, mid, left, right), queryMin(node*2+1, mid+1, end, left, right))

def queryMax(node, start, end, left, right):
    if start > right or end < left:
        return 0
    if left <= start and end <= right:
        return tree_max[node]

    mid = (start+end)//2
    return max(queryMax(node*2, start, mid, left, right), queryMax(node*2+1, mid+1, end, left, right))

n, m = map(int, input().split())
arr = [int(input()) for _ in range(n)]
h = int(ceil(log2(n)))
t_size = 1 << (h+1)

tree_min = [0] * t_size
tree_max = [0] * t_size

initMin(1, 0, n-1)
initMax(1, 0, n-1)

for _ in range(m):
    a, b = map(int, input().split())
    print(queryMin(1, 0, n-1, a-1, b-1), queryMax(1, 0, n-1, a-1, b-1))
