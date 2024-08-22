import sys
input = lambda: sys.stdin.readline().rstrip()

def Modify(node, start, end, idx, value):
    if idx < start or idx > end:
        return
    
    if start == end:
        tree[node] = value
        return
    
    mid = (start+end)//2
    Modify(node*2, start, mid, idx, value)
    Modify(node*2+1, mid+1, end, idx, value)

    tree[node] = tree[node*2]+tree[node*2+1]

def Sum(node, start, end, left, right):
    if left > end or right < start:
        return 0

    if left <= start and right >= end:
        return tree[node]
    
    mid = (start+end)//2

    return Sum(node*2, start, mid, left, right) + Sum(node*2+1, mid+1, end, left, right)


n, m = map(int, input().split())
tree = [0]*(4*n)

for _ in range(m):
    q, a, b = map(int, input().split())

    if q == 0:
        if a > b:
            a, b = b, a
        print(Sum(1, 0, n-1, a-1, b-1))
    else:
        Modify(1, 0, n-1, a-1, b)
