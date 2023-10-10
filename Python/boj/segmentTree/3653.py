import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil, log2

def init(start, end, node):
    if start == end:
        tree[node] = 1
        return tree[node]
    mid = (start+end)//2
    tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1)
    return tree[node]

def query(start, end, node, left, right):
    if left > end or right < start: return 0
    if left <= start and end <= right: return tree[node]
    mid = (start+end)//2
    return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right)

def update(start, end, node, idx, diff):
    if start > idx or end < idx: return
    tree[node] += diff
    if start == end: return
    mid = (start+end)//2
    update(start, mid, node*2, idx, diff)
    update(mid+1, end, node*2+1, idx, diff)


for _ in range(int(input())):
    n, m = map(int, input().split())
    idx = list(range(n+1, 0, -1))
    h = ceil(log2(n+m+1))
    tree = [0]*(1<<(h+1))

    init(1, n+m, 1)

    cnt = 1
    for x in map(int, input().split()):
        now = idx[x]
        idx[x] = n+cnt
        print(query(1, n+m, 1, now+1, n+cnt-1), end=' ')
        update(1, n+m, 1, now, -1)
        cnt += 1
    print()
