import sys
input = lambda: sys.stdin.readline().rstrip()

# fenwick tree (Binary Index Tree, BIT)
# L[i] = (i & -i)
# -num = ~num + 1
# num        = 100110101110101100000000000
# ~num       = 011001010001010011111111111
# -num       = 011001010001010011111111111 
# num & -num = 000000000000000100000000000

MAX = 200_000
MOD = 1_000_000_007

def update_cnt(target, value):
    while target <= MAX:
        tree_cnt[target] += value
        target += (target & -target)

def update_dist(target, value):
    while target <= MAX:
        tree_dist[target] += value
        target += (target & -target)

def query_cnt(target):
    ret = 0
    while target >= 1:
        ret += tree_cnt[target]
        target -= (target & -target)
    return ret

def query_dist(target):
    ret = 0
    while target >= 1:
        ret += tree_dist[target]
        target -= (target & -target)
    return ret


N = int(input())
tree_cnt = [0]*(MAX+1)
tree_dist = [0]*(MAX+1)
ans = 1
for i in range(N):
    tmp = 0
    t = int(input())+1
    if i == 0:
        update_cnt(t, 1)
        update_dist(t, t)
    else:
        tmp = (tmp + (query_cnt(t-1)*t) - (query_dist(t-1))) % MOD
        tmp = (tmp + (query_dist(MAX)-query_dist(t)) - (query_cnt(MAX)-query_cnt(t))*t) % MOD
        update_cnt(t, 1)
        update_dist(t, t)
        ans = (ans*tmp) % MOD

print(ans%MOD)
