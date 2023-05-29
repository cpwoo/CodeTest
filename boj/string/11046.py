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
num = list(map(int, input().split()))
nums = [0]*(2*n+1)
nums[1::2] = num
a = manacher(nums)

for _ in range(int(input())):
    s, e = map(int, input().split())
    center, rad = s+e-1, e-s
    print("1" if rad <= a[center] else "0")
