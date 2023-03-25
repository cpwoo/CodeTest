import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]

    mid = (start+end)//2
    tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end)
    return tree[node]

def update(node, start, end, idx, diff):
    if idx < start or end < idx:
        return

    tree[node] += diff

    if start != end:
        mid = (start+end)//2
        update(node*2, start, mid, idx, diff)
        update(node*2+1, mid+1, end, idx, diff)

def query(node, start, end, left, right):
    if right < start or end < left:
        return 0
    
    if left <= start and end <= right:
        return tree[node]

    mid = (start+end)//2
    return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right) 


n, q = map(int, input().split())
arr = list(map(int, input().split()))

h = int(ceil(log2(n)))
t_size = 1 << (h+1)

tree = [0] * t_size
init(1, 0, n-1)

for _ in range(q):
    x, y, a, b = map(int, input().split())

    if x <= y:
        print(query(1, 0, n-1, x-1, y-1))
    else:
        print(query(1, 0, n-1, y-1, x-1))

    diff = b - arr[a-1]
    arr[a-1] = b
    update(1, 0, n-1, a-1, diff)
