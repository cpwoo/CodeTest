import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[a] = b

def upper_bound(key):
    s, e = 0, m-1
    while s <= e:
        mid = (s+e)//2
        if my[mid] <= key:
            s = mid+1
        else:
            e = mid-1
    return s


n, m, k = map(int, input().split())
my = sorted(list(map(int, input().split())))
parent = list(range(m+1))
enemy = list(map(int, input().split()))

for num in enemy:
    idx = upper_bound(num)
    choice_idx = find(idx)
    print(my[choice_idx])
    union(choice_idx, choice_idx+1)
