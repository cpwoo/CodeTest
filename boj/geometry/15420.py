import sys
input = lambda: sys.stdin.readline().rstrip()

# 4225번과 비슷한 로직이나 N^2는 시간초과
# 회전하는 캘리퍼스를 이용하여 시간 단축

INF = sys.maxsize

def width(p1, p2, p3):
    hyp = ((p1[0]-p2[0])**2 + (p1[1]-p2[1])**2)**0.5
    area = abs(p3[0]*(p2[1]-p1[1]) - p3[1]*(p2[0]-p1[0]) + p1[1]*p2[0] - p1[0]*p2[1])
    return area/hyp

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

d = INF
c = len(cvxh)
p = 1
for i in range(c):
    while (p+1)%c != i and width(cvxh[i], cvxh[(i+1)%c], cvxh[p]) <= width(cvxh[i], cvxh[(i+1)%c], cvxh[(p+1)%c]):
        p = (p+1)%c
    now = width(cvxh[i], cvxh[(i+1)%c], cvxh[p])
    d = min(d, now)

print(d)
