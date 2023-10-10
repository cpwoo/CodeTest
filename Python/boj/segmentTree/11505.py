import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

def init(start, end, node):
    if start == end:
        tree[node] = arr[start]
        return tree[node]

    mid = (start+end)//2
    tree[node] = init(start, mid, node*2) * init(mid+1, end, node*2+1) % MOD
    return tree[node]

def summit(start, end, node, left, right):
    if left > end or right < start:
        return 1

    if left <= start and end <= right:
        return tree[node]

    mid = (start+end)//2
    return summit(start, mid, node*2, left, right) * summit(mid+1, end, node*2+1, left, right) % MOD

def update(start, end, node, idx, diff):
    if idx < start or end < idx:
        return

    if start == end:
        tree[node] = diff
    else:
        mid = (start+end)//2
        update(start, mid, node*2, idx, diff)
        update(mid+1, end, node*2+1, idx, diff)
        tree[node] = tree[2*node] * tree[2*node+1] % MOD


N, M, K = map(int, input().split())
arr = [int(input()) for _ in range(N)]
tree = [0] * (4*N)
init(0, N-1, 1)

for _ in range(M+K):
    cmd = list(map(int, input().split()))

    if cmd[0] == 1:
        update(0, N-1, 1, cmd[1]-1, cmd[2])

    elif cmd[0] == 2:
        print(summit(0, N-1, 1, cmd[1]-1, cmd[2]-1))
