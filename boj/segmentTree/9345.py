import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil, log2

# 트리의 각 노드를 왼쪽 자식의 최솟값과 오른쪽 자식의 최댓값으로 설정

def init(start, end, node):
    if start == end:
        tree[node] = (nums[start], nums[start])
        return
    mid = (start+end)//2
    init(start, mid, node*2)
    init(mid+1, end, node*2+1)
    tree[node] = (tree[node*2][0], tree[node*2+1][1])


def update(start, end, node, idx, val):
    if start > idx or end < idx: return
    if start == end:
        tree[node] = (val, val)
        return

    mid = (start+end)//2
    update(start, mid, node*2, idx, val)
    update(mid+1, end, node*2+1, idx, val)
    tree[node] = (min(tree[node*2][0], tree[node*2+1][0]), max(tree[node*2][1], tree[node*2+1][1]))

# 범위 안에 들어올 때 트리의 값이 최소값에서 최댓값 사이면 True, 아니면 False

def query(start, end, node, left, right):
    if left > end or right < start: return True
    if left <= start and end <= right:
        if left <= tree[node][0] and right >= tree[node][1]:
            return True
        else:
            return False
        
    mid = (start+end)//2
    return query(start, mid, node*2, left, right) and query(mid+1, end, node*2+1, left, right)


for _ in range(int(input())):
    n, k = map(int, input().split())
    nums = list(range(n+1))
    h = ceil(log2(n))
    tree = [(-1, -1)]*(1<<(h+1)+1)

    init(1, n, 1)
    for _ in range(k):
        q, a, b = map(int, input().split())
        a += 1; b += 1

        if q == 0:
            update(1, n, 1, a, nums[b])
            update(1, n, 1, b, nums[a])
            nums[a], nums[b] = nums[b], nums[a]
        else:
            print("YES" if query(1, n, 1, a, b) else "NO")
