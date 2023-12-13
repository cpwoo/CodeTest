import sys
input = lambda: sys.stdin.readline().rstrip()

def distance(u, v):
    return abs(u[0]-v[0])+abs(u[1]-v[1])

N, T = map(int, input().split())

special = set()
pos = [[] for _ in range(N)]

for i in range(N):
    s, x, y = map(int, input().split())
    if s == 1:
        special.add(i)
    pos[i] = [x, y]

dist = [1001]*N

for i in range(N):
    val = 1001
    for s in special:
        tmp = distance(pos[i], pos[s])
        val = min(val, tmp)
    dist[i] = val

for _ in range(int(input())):
    p, q = map(lambda t: int(t)-1, input().split())
    print(min(distance(pos[p], pos[q]), dist[p]+T+dist[q]))
