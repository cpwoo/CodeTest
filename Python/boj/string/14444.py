import sys
input = lambda: sys.stdin.readline().rstrip()

def manacher(st):
    n = len(st)
    a = [0]*n
    c = 0
    r = 0
    for now in range(n):        
        if r < now:
            a[now] = 0
        else:
            a[now] = min(a[(2*c)-now], r-now)
        
        while now-(a[now]+1) >= 0 and now+(a[now]+1) < n and st[now-(a[now]+1)] == st[now+(a[now]+1)]:
            a[now] += 1
        
        if r < now+a[now]:
            r = now+a[now]
            c = now
    
    return max(a)


s = input()
print(manacher("#" + "#".join(s) + "#"))
