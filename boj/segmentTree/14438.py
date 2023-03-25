import sys
input = lambda: sys.stdin.readline().rstrip()

mid = lambda a,b: (a+b)//2
INF = sys.maxsize

def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
    else:
        init(node*2, start, mid(start,end))
        init(node*2+1, mid(start,end)+1, end)
        tree[node] = min(tree[node*2], tree[node*2+1])

def update(node, start, end, idx, num):
    if idx < start or idx > end: return
    if start == end:
        arr[start], tree[node] = num, num
        return tree[node]
    update(node*2, start, mid(start,end), idx, num)
    update(node*2+1, mid(start,end)+1, end, idx, num)
    tree[node] = min(tree[node*2], tree[node*2+1])

def find(node, start, end, left, right):
    if left > end or right < start: return INF
    if left <= start and end <= right: return tree[node]
    return min(find(node*2, start, mid(start,end), left, right), find(node*2+1, mid(start,end)+1, end, left, right))


n = int(input())
arr = [0] + list(map(int, input().split()))
tree = [0] * 270000
init(1, 1, n)

for _ in range(int(input())):
    a, b, c = map(int, input().split())
    if a == 1:
        update(1, 1, n, b, c)
    else:
        print(find(1, 1, n, b, c))
