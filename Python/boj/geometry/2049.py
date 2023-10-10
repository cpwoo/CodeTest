import sys
input = lambda: sys.stdin.readline().rstrip()

# 1310번과 동일한 문제 (같은 코드로 제출해도 정답)

def dist(p1, p2):
    return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n = int(input())
points = sorted([list(map(int, input().split())) for _ in range(n)])

down = []
for i in range(n):
    while len(down) > 1:
        if ccw(down[-2], down[-1], points[i]) > 0:
            break
        down.pop()
    down.append(points[i])

up = []
for i in range(n-1, -1, -1):
    while len(up) > 1:
        if ccw(up[-2], up[-1], points[i]) > 0:
            break
        up.pop()
    up.append(points[i])

cvxh = down[:-1] + up[:-1]
l, r = 0, len(down)-1
d = dist(cvxh[l], cvxh[r])
c = len(cvxh)
for _ in range(c):
    lx, ly = cvxh[l]
    nlx, nly = cvxh[(l+1)%c]
    rx, ry = cvxh[r]
    nrx, nry = cvxh[(r+1)%c]
    if ccw([nlx-lx, nly-ly], [0, 0], [nrx-rx, nry-ry]) > 0:
        l = (l+1)%c
    else:
        r = (r+1)%c
    d = max(d, dist(cvxh[l], cvxh[r]))

print(d)
