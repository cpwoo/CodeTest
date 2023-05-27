import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]
check = deepcopy(points)
level = [0]*n

cnt = 1
while len(points) >= 3:
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
    
    if len(cvxh) < 3:
        break

    for c in cvxh:
        level[check.index([c[0], c[1]])] = cnt
        points.remove(c)
    cnt += 1

print(*level)
