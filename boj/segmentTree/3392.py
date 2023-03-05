import sys
input = lambda: sys.stdin.readline().rstrip()

def update(node, start, end, left, right, val):
    if end < left or start > right: return
    if left <= start and end <= right: cnt[node] += val
    else:
        mid = (start+end)//2
        update(node*2, start, mid, left, right, val)
        update(node*2+1, mid+1, end, left, right, val)

    if cnt[node] > 0:
        seg[node] = end-start+1
    else:
        seg[node] = seg[node*2]+seg[node*2+1]


n = int(input())
arr = []
for _ in range(n):
    x1, y1, x2, y2 = map(int, input().split())
    arr.append((x1, y1, y2-1, 1))
    arr.append((x2, y1, y2-1, -1))
arr.sort()

seg = [0]*(30001*2*4)
cnt = [0]*(30001*2*4)

ans = 0
x, y1, y2, val = arr[0]
update(1, 0, 30000, y1, y2, val)

for i in range(1, n*2):
    dx = arr[i][0]-arr[i-1][0]
    ans += dx*seg[1]
    update(1, 0, 30000, arr[i][1], arr[i][2], arr[i][3])

print(ans)
