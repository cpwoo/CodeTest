import sys
input = lambda: sys.stdin.readline().rstrip()

MAX = 1_000_000

def init(n, s, e, t, v):
    if t < s or e < t:
        return tree[n]
     
    if s == t == e:
        tree[n] += v
        arr[n] = t
        return tree[n]
     
    m = (s+e)//2
    tree[n] = init(n*2, s, m, t, v) + init(n*2+1, m+1, e, t, v)

    return tree[n]

def get(n, s, e, g):
    if s == e:
        tree[n] -= 1
        print(arr[n])
        return tree[n]
     
    L = tree[n*2]
    m = (s+e)//2
    if L >= g:
        get(n*2, s, m, g)
    else:
        get(n*2+1, m+1, e, g-L)

    tree[n] = tree[n*2]+tree[n*2+1]

    return tree[n]


N = int(input())
tree = [0]*(MAX*4)
arr = [0]*(MAX*4)

for _ in range(N):
    cmd = list(map(int, input().split()))
    if cmd[0] == 1:
        get(1, 1, MAX, cmd[1])
    elif cmd[0] == 2:
        init(1, 1, MAX, cmd[1], cmd[2])
