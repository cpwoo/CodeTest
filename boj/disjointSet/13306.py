import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(200000)

def find(x):
    if all_node[x][1] != x:
        all_node[x][1] = find(all_node[x][0])
        all_node[x][0] = all_node[x][1]
    return all_node[x][1]


n, q = map(int, input().split())
all_node = [[0, 0] for _ in range(n+1)]
all_node[1][1] = 1

for i in range(2, n+1):
    tmp = int(input())
    all_node[i] = [tmp, i]

query = [list(map(int, input().split())) for _ in range(n+q-1)]

result = []
for _ in range(n+q-1):
    tmp = query.pop()
    if tmp[0] == 0:
        all_node[tmp[1]][1] = all_node[tmp[1]][0]
    elif tmp[0] == 1:
        root1, root2 = find(tmp[1]), find(tmp[2])
        if root1 == root2:
            result.append(True)
        else:
            result.append(False)

for _ in range(q):
    tmp = result.pop()
    print("YES" if tmp else "NO")
