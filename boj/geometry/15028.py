import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

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

d = INF
c = len(cvxh)
for i in range(c):
    tmp = 0
    if cvxh[i][0] == cvxh[(i+1)%c][0]:
        for j in range(c):
            tmp = max(tmp, abs(cvxh[i][0]-cvxh[j][0]))
        d = min(d, tmp)
        continue
    p = (cvxh[(i+1)%c][1]-cvxh[i][1])/(cvxh[(i+1)%c][0]-cvxh[i][0])
    q = -1
    r = cvxh[i][1]-p*cvxh[i][0]
    for j in range(c):
        tmp = max(tmp, abs(p*cvxh[j][0]+q*cvxh[j][1]+r)/((p*p+q*q)**0.5))
    d = min(d, tmp)

print(d)
