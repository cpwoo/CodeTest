import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)

def cross_check(p1, p2, p3, p4):
    abc, abd = ccw(p1, p2, p3), ccw(p1, p2, p4)
    cda, cdb = ccw(p3, p4, p1), ccw(p3, p4, p2)
    if abc == 0 and abd == 0:
        if p2 < p3 or p4 < p1:
            return 0
        if p2 == p3 or p4 == p1:
            return 1
        return 3
    if abc == 0 or abd == 0:
        if cda == cdb:
            return 0
        return 1
    if cda == 0 or cdb == 0:
        if abc == abd:
            return 0
        return 1
    if abc+abd == 0 and cda+cdb == 0:
        return 2
    return 0


n = int(input())
points = [[[0]*2 for _ in range(2)] for _ in range(n)]
for i in range(n):
    points[i][0][0], points[i][0][1], points[i][1][0], points[i][1][1] = map(int, input().split())
    if points[i][0] > points[i][1]:
        points[i][0], points[i][1] = points[i][1], points[i][0]

ret = [[0]*n for _ in range(n)]
for i in range(n):
    ret[i][i] = 3
    for j in range(i):
        p1, p2, p3, p4 = points[j][0], points[j][1], points[i][0], points[i][1]
        res = cross_check(p1, p2, p3, p4)
        ret[i][j] = ret[j][i] = res

for row in ret:
    print(*row, sep="")
