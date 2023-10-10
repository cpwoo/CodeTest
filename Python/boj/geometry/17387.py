import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    tmp = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p2[0]*p1[1] + p3[0]*p2[1] + p1[0]*p3[1])
    return tmp//abs(tmp) if tmp != 0 else 0

def checkCross(p1, p2, p3, p4):
    is_result = False
    result = 0

    p123, p124 = ccw(p1, p2, p3), ccw(p1, p2, p4)
    p341, p342 = ccw(p3, p4, p1), ccw(p3, p4, p2)

    if p123 * p124 == 0 and p341 * p342 == 0:
        is_result = True
        if min(p1[0], p2[0]) <= max(p3[0], p4[0]) and min(p3[0], p4[0]) <= max(p1[0], p2[0]) and min(p1[1],p2[1])<=max(p3[1],p4[1]) and min(p3[1],p4[1])<=max(p1[1],p2[1]):
            result = 1
    
    if p123 * p124 <= 0 and p341 * p342 <= 0:
        if not is_result:
            result = 1

    return result


x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

A, B, C, D = [x1, y1], [x2, y2], [x3, y3], [x4, y4]

print(checkCross(A, B, C, D))
