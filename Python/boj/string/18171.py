import sys
input = lambda: sys.stdin.readline().rstrip()

def manacher(st):
    L = len(st)
    a = [0]*L
    c = 0
    r = 0
    for now in range(L):
        if r < now:
            a[now] = 0
        else:
            a[now] = min(a[(2*c)-now], r-now)
        
        while now-(a[now]+1) >= 0 and now+(a[now]+1) < L and st[now-(a[now]+1)] == st[now+(a[now]+1)]:
            a[now] += 1
        
        if r < now+a[now]:
            r = now+a[now]
            c = now
    
    return a


n = int(input())
st = input()
a = manacher("#" + "#".join(st) + "#")
rad = 0
for c, r in enumerate(a):
    if c+r == 2*n:
        rad = max(rad, r)

print(n-rad)
