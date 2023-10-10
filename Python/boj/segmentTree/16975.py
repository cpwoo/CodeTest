import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil, log2

def update(start, end, left, right, node, diff):
    if right < start or left > end: return
    if left <= start and end <= right:
        tree[node] += diff
        return
    mid = (start+end)//2
    update(start, mid, left, right, node*2, diff)
    update(mid+1, end, left, right, node*2+1, diff)

def find(node):
    global ans
    while node >= 1:
        ans += tree[node]
        node //= 2


n = int(input())
size = 1<<(ceil(log2(n)))
tree = [0]*(size<<1)

for i, j in enumerate(list(map(int, input().split()))):
    tree[size+i] = j

for _ in range(int(input())):
    query = list(map(int, input().split()))
    if query[0] == 1:
        update(1, size, query[1], query[2], 1, query[3])
    else:
        ans = 0
        find(size+query[1]-1)
        print(ans)
