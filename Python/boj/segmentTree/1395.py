import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil, log2

def propagate(node, start, end):
    if lazy[node] != 0:
        tree[node] = (end-start+1)-tree[node]

        if start != end:
            lazy[node*2] ^= 1
            lazy[node*2+1] ^= 1

        lazy[node] = 0

def update(node, start, end, left, right):
    propagate(node, start, end)

    # Out of range
    if right < start or end < left:
        return

    # In range
    if left <= start and end <= right:
        tree[node] = (end-start+1)-tree[node]

        if start != end:
            lazy[node*2] ^= 1
            lazy[node*2+1] ^= 1

        return

    mid = (start + end)//2
    update(node*2, start, mid, left, right)
    update(node*2+1, mid+1, end, left, right)
    tree[node] = tree[node*2] + tree[node*2+1]

def query(node, start, end, left, right):
    propagate(node, start, end)

    # Out of range
    if right < start or end < left:
        return 0

    # In range
    if left <= start and end <= right:
        return tree[node]

    mid = (start + end)//2
    return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right)


N, M = map(int, input().split())

if N&(N-1) == 0:
    length = N<<1
else:
    length = 1<<(ceil(log2(N))+1)

tree = [0]*length
lazy = [0]*length

for _ in range(M):
    o, s, t = map(int, input().split())
    if o == 0:
        update(1, 1, N, s, t)
    else:
        print(query(1, 1, N, s, t))
