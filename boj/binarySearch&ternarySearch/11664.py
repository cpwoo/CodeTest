import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

ax, ay, az, bx, by, bz, cx, cy, cz = map(int, input().split())

ans = INF
while True:
    mx, my, mz = (ax+bx)/2, (ay+by)/2, (az+bz)/2
    l = ((ax-cx)**2+(ay-cy)**2+(az-cz)**2)**0.5
    m = ((mx-cx)**2+(my-cy)**2+(mz-cz)**2)**0.5
    r = ((bx-cx)**2+(by-cy)**2+(bz-cz)**2)**0.5
    if abs(ans-m) <= 1e-6:
        print("%.10f" %ans)
        break
    if m < ans:
        ans = m
    if l > r:
        ax, ay, az = mx, my, mz
    else:
        bx, by, bz = mx, my, mz
