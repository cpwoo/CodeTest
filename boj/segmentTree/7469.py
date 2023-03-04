import sys
input = lambda: sys.stdin.readline().rstrip()

# 13537번과 유사 문제

from bisect import bisect_right

def merge(left, right):
    ret = []
    i = j = 0
    l, r = len(left), len(right)
    while True:
        if i == l:
            for k in range(j, r):
                ret.append(right[k])
            break
        if j == r:
            for k in range(i, l):
                ret.append(left[k])
            break
        if left[i] < right[j]:
            ret.append(left[i])
            i += 1
        else:
            ret.append(right[j])
            j += 1
    return ret


def init(idx, start, end):
    if start == end:
        tree[idx].append(arr[start-1])
        return
    mid = (start+end)>>1
    init(idx*2, start, mid); init(idx*2+1, mid+1, end)
    tree[idx] = merge(tree[idx*2], tree[idx*2+1])


def query(idx, start, end, x, left, right):
    if end < left or right < start: return 0
    if left <= start and end <= right:
        return bisect_right(tree[idx], x)
    mid = (start+end)>>1
    return query(idx*2, start, mid, x, left, right) + query(idx*2+1, mid+1, end, x, left, right)


n, m = map(int, input().split())
arr = list(map(int, input().split()))
tree = [[] for _ in range(1<<18)]
init(1, 1, n)

for _ in range(m):
    i, j, k = map(int, input().split())
    left, right = -int(1e9), int(1e9)
    while left <= right:
        x = (left+right)//2
        result = query(1, 1, n, x, i, j)
        if result < k:
            left = x+1
        else:
            right = x-1

    print(left)
