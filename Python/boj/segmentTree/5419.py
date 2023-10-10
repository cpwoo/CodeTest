import sys
input = lambda: sys.stdin.readline().rstrip()

def update(idx):
    tree[idx] += 1
    idx >>= 1
    while idx != 0:
        tree[idx] = tree[idx*2] + tree[idx*2+1]
        idx >>= 1


def query(start, end, left, right, idx):
    if left <= start and right >= end:
        return tree[idx]
    if end < left or right < start:
        return 0
    mid = (start + end) // 2 
    return query(start, mid, left, right, idx*2) + query(mid+1, end, left, right, idx*2+1)


for _ in range(int(input())):
    nodes = []
    for _ in range(int(input())):
        nodes.append(list(map(int, input().split())))
    nodes.sort(key=lambda x: x[1])

    p = [0, nodes[0][1]]
    for a in range(len(nodes)):
        if p[1] == nodes[a][1]:
            nodes[a][1] = p[0]
        else:
            p[0] += 1
            p[1] = nodes[a][1]
            nodes[a][1] = p[0]

    nodes.sort(key=lambda x: (x[0], -x[1]))

    val = 131072
    tree = [0] * (val*2)

    ans = 0
    for node in nodes:
        ans += query(0, val - 1, node[1], val - 1, 1)
        update(val+node[1])

    print(ans)
