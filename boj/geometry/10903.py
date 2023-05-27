import sys
input = lambda: sys.stdin.readline().rstrip()

from math import pi

def dist(p1, p2):
    return ((p1[0]-p2[0])**2 + (p1[1]-p2[1])**2)**0.5

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n, r = map(int, input().split())
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

d = 0
c = len(cvxh)
for i in range(c):
    d += dist(cvxh[i], cvxh[(i+1)%c])

print(d+2*r*pi)
