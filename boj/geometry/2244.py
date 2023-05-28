import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n, m = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
B = [list(map(int, input().split())) for _ in range(m)]

points = []
for x1, y1 in A:
    for x2, y2 in B:
        points.append([x1+x2, y1+y2])
points.sort()

P = len(points)

down = []
for i in range(P):
    while len(down) > 1:
        if ccw(down[-2], down[-1], points[i]) > 0:
            break
        down.pop()
    down.append(points[i])

up = []
for i in range(P-1, -1, -1):
    while len(up) > 1:
        if ccw(up[-2], up[-1], points[i]) > 0:
            break
        up.pop()
    up.append(points[i])

cvxh = down[:-1] + up[:-1]

print(len(cvxh))
for c in cvxh:
    print(*c)
