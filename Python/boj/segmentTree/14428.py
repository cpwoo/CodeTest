import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

INF = sys.maxsize

def min(a : list, b : list) -> list:
    if a[0] > b[0]:
        return b
    else:
        return a

def init(node, start, end):
    if start == end:
        tree[node] = values[start]
        return tree[node]

    mid = (start+end)//2
    tree[node] = min(init(node*2, start, mid), init(node*2+1, mid+1, end))
    return tree[node]

def query(node, start, end, left, right):
    if start > right or end < left:
        return [INF, INF]

    if left <= start and end <= right:
        return tree[node]

    mid = (start+end)//2
    return min(query(node*2, start, mid, left, right), query(node*2+1, mid+1, end, left, right))

def update(node, start, end, index, x):
    if index < start or index > end:
        return [INF, INF]

    if start == end:
        tree[node] = x
        return

    mid = (start+end)//2
    update(node*2, start, mid, index, x)
    update(node*2+1, mid+1, end, index, x)

    tree[node] = min(tree[node*2], tree[node*2+1])


N = int(input())

temp = list(map(int, input().split()))
values = [[0, 0] for _ in range(N)]
for i in range(N):
    values[i][0] = temp[i]
    values[i][1] = i+1

h_size = 1 << (int(ceil(log2(N))) + 1)
tree = [0] * h_size

init(1, 0, N-1)

M = int(input())
for _ in range(M):
    A, B, C = map(int, input().split())
	
    if A == 1:
        values[B-1][0] = C
        update(1, 0, N-1, B-1, values[B-1])
	
    else:
        print(query(1, 0, N-1, B-1, C-1)[1])
