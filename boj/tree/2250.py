import sys
input = lambda: sys.stdin.readline().rstrip()

def in_order(node, level):
    global idx
    left, right = graph[node].values()
    if left != -1:
        in_order(left, level+1)

    node_per_level[level].append(idx)
    idx += 1

    if right != -1:
        in_order(right, level+1)


n = int(input())
graph = dict()
parent_check = [False] * n
node_per_level = [[] for _ in range(n)]
idx = 1

for _ in range(n):
    node, left, right = map(int, input().split())

    if left != -1:
        parent_check[left-1] = True
    if right != -1:
        parent_check[right-1] = True
    graph[node] = {'l': left, 'r': right}

root = parent_check.index(False) + 1

in_order(root, 0)

max_level, max_level_width = 0, 0

for level, nodes in enumerate(node_per_level):
    if nodes:
        width = max(nodes) - min(nodes) + 1
        if max_level_width < width:
            max_level_width = width
            max_level = level + 1

print(max_level, max_level_width)
