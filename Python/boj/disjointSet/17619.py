import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[b] = a


N, Q = map(int, input().split())

arr = []
for i in range(N):
    a, b, c = map(int, input().split())
    arr.append((a, b, i))
arr.sort()

parent = list(range(N))

cur_start, cur_end, cur_idx = arr[0]
for i in range(1, N):
    nxt_start, nxt_end, nxt_idx = arr[i]
    if cur_start <= nxt_start <= cur_end:
        union(cur_idx, nxt_idx)
        if cur_end <= nxt_end:
            cur_start, cur_end, cur_idx = nxt_start, nxt_end, nxt_idx
    else:
        cur_start, cur_end, cur_idx = nxt_start, nxt_end, nxt_idx

for _ in range(Q):
    a, b = map(lambda t: int(t)-1, input().split())
    print(1 if parent[a] == parent[b] else 0)
