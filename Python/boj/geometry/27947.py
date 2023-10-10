import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    return (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])

def area(points, idx):
    points = sorted(points[:idx+3])
    down = []
    for i in range(idx+3):
        while len(down) > 1:
            if ccw(down[-2], down[-1], points[i]) > 0:
                break
            down.pop()
        down.append(points[i])

    up = []
    for i in range(idx+2, -1, -1):
        while len(up) > 1:
            if ccw(up[-2], up[-1], points[i]) > 0:
                break
            up.pop()
        up.append(points[i])

    cvxh = down[:-1] + up[:-1]
    ret = 0
    for i in range(1, len(cvxh)-1):
        ret += ccw(cvxh[0], cvxh[i], cvxh[i+1])

    return ret//2


n, s = map(int, input().split())
points = [list(map(int, input().split())) for _ in range(n+3)]

start, end = 0, n
while start+1 < end:
    mid = (start+end)//2
    A = area(points, mid)
    if A >= s:
        end = mid
    else:
        start = mid

if area(points, n) < s:
    print("draw")
elif end%2 == 1:
    print("wapas")
else:
    print("wider")
