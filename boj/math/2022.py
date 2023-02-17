import sys
input = lambda: sys.stdin.readline().rstrip()

x, y, c = map(float, input().split())

left, right = 0, min(x, y)
res = 0
while abs(right-left) > 1e-6:
    mid = (left+right)/2.0
    d = mid
    h1, h2 = pow((x*x-d*d), 0.5), pow((y*y-d*d), 0.5)
    h = (h1*h2)/(h1+h2)

    if h > c:
        left = mid
        res = mid
    else:
        right = mid

print("%.3f" %res)
