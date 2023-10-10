import sys
input = lambda: sys.stdin.readline().rstrip()

from math import *

def update(node, start, end, idx):
    if idx < start or end < idx:
        return 0
    if start == end:
        tree[node] = 1
        return tree[node]
     
    mid = (start+end)//2
    update(node*2, start, mid, idx)
    update(node*2+1, mid+1, end, idx)
    tree[node] = tree[node*2]+tree[node*2+1]
    return tree[node]

def query(node, start, end, left, right):
    if right < start or end < left:
        return 0

    if left <= start and end <= right:
        return tree[node]

    mid = (start+end)//2
    return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right)


n = int(input())
A = input().split()

idx = 0
B = {}
for num in input().split():
    B[num] = idx
    idx += 1

tree = [0]*(1<<ceil(log2(n))+1)

answer = 0 
for num in A:
    s_idx = B[num]
    answer += query(1, 0, n-1, s_idx, n-1)
    update(1, 0, n-1, s_idx)

print(answer)
