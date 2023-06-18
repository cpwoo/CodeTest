import sys
input = lambda: sys.stdin.readline().rstrip()

a, b = input().split()
p = len(a[a.index(".")+1:])
a = a.replace(".","")

res = str(int(a)**int(b))
p = str((10**p)**int(b))
idx = len(res)-len(p)+1

print(res[:idx]+"."+res[idx:] if idx >= 0 else "0."+"0"*(-idx)+res)
