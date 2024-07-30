import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        r = find(parent[x])
        dist[x] += dist[parent[x]]
        parent[x] = r
    return parent[x]

def union(x, y, k):
    xroot, yroot = parent[x], parent[y]
    if xroot != yroot:
        parent[yroot] = xroot
        dist[yroot] = (dist[x]+k)-dist[y]


while True:
    n, m = map(int, input().split())
    if (n, m) == (0, 0): break
    parent = list(range(n+1))
    dist = [0]*(n+1)
    for _ in range(m):
        cmd = list(input().split())
        cmd[1:] = list(map(int, cmd[1:]))
        find(cmd[1]); find(cmd[2])
        
        if cmd[0] == "!":
            union(cmd[1], cmd[2], cmd[3])
        else:
            if parent[cmd[1]] == parent[cmd[2]]:
                print(dist[cmd[2]]-dist[cmd[1]])
            else:
                print("UNKNOWN")
