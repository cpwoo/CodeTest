import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n = int(input())
arr = list(map(int, input().split()))

points = [[0, 0]]
for i in range(n):
    points.append([i+1, points[-1][1]+arr[i]])

up = []
for pt in points[::-1]:
    while len(up) > 1:
        if ccw(up[-2], up[-1], pt) >= 0:
            break
        up.pop()
    up.append(pt)

up.sort()

ret = [[0, 0]]
for nx, ny in up[1:]:
    x, y = ret[-1]
    dx, dy = nx-x, ny-y
    for i in range(x+1, nx+1):
        ret.append([i, y+dy/(nx-x)*(i-x)])

flag = True
for i in range(n+1):
    if not (0 <= ret[i][1]-points[i][1] < 1):
        flag = False
        break

print("Provable" if not flag else "Not Provable")
