import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil, log2

def init(idx, start, end):
    if start == end:
        tree[idx] = arr[start]
        return
    
    mid = (start+end)//2
    init(idx*2, start, mid); init(idx*2+1, mid+1, end)
    tree[idx] = tree[idx*2] ^ tree[idx*2+1]

def propagate(idx, start, end):
    if lazy[idx] != 0:
        if (end-start+1)%2 == 1:
            tree[idx] ^= lazy[idx]
        if start != end:
            lazy[idx*2] ^= lazy[idx]
            lazy[idx*2+1] ^= lazy[idx]
        lazy[idx] = 0

def update(idx, start, end, val, left, right):
    propagate(idx, start, end)

    if right < start or end < left: return
    if left <= start and end <= right:
        lazy[idx] ^= val
        propagate(idx, start, end)
        return

    mid = (start+end)//2
    update(idx*2, start, mid, val, left, right)
    update(idx*2+1, mid+1, end, val, left, right)
    tree[idx] = tree[idx*2] ^ tree[idx*2+1]

def query(idx, start, end, left, right):
    propagate(idx, start, end)
    
    if right < start or end < left: return 0
    if left <= start and end <= right: return tree[idx]

    mid = (start+end)//2
    res1 = query(idx*2, start, mid, left, right)
    res2 = query(idx*2+1, mid+1, end, left, right)
    return res1 ^ res2


n = int(input())
arr = list(map(int, input().split()))
h = ceil(log2(n))
tree = [0]*(1<<(h+1))
lazy = [0]*(1<<(h+1))

init(1, 0, n-1)
for _ in range(int(input())):
    cmd = list(map(int, input().split()))
    if cmd[0] == 1:
        update(1, 0, n-1, cmd[3], cmd[1], cmd[2])
    else:
        print(query(1, 0, n-1, cmd[1], cmd[2]))
