import sys
input = lambda: sys.stdin.readline().rstrip()

# merge sort 실행 => segment tree 와 구조가 비슷하므로 segment tree 이용

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


def query(idx, start, end, k, left, right):
    if end < left or right < start: return 0
    if left <= start and end <= right:
        return len(tree[idx]) - bisect_right(tree[idx], k)
    mid = (start+end)>>1
    return query(idx*2, start, mid, k, left, right) + query(idx*2+1, mid+1, end, k, left, right)


n = int(input())
arr = list(map(int, input().split()))
tree = [[] for _ in range(1<<18)]
init(1, 1, n)

for _ in range(int(input())):
    i, j, k = map(int, input().split())
    print(query(1, 1, n, k, i, j))
