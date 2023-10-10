import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

def union(x, y, idx):
    global endgame
    x, y = find(x), find(y)
    if x != y:
        parents[max(x, y)] = min(x, y)
    elif endgame == 0:
        endgame = idx


N, M = map(int, input().split())
parents = list(range(N))
endgame = 0

for i in range(M):
    a, b = map(int, input().split())
    union(a, b, i+1)

print(endgame)
