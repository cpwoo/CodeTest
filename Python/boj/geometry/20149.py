import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)

def check(p1, p2, p3, p4):
    if ccw(p1,p2,p3)*ccw(p1,p2,p4) == 0 and ccw(p3,p4,p1)*ccw(p3,p4,p2) == 0:
        if p2 >= p3 and p1 <= p4:
            return True
        else:
            return False
    if ccw(p1,p2,p3)*ccw(p1,p2,p4) <= 0 and ccw(p3,p4,p1)*ccw(p3,p4,p2) <= 0:
        return True
    return False


x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

p1, p2, p3, p4 = [x1, y1], [x2, y2], [x3, y3], [x4, y4]
if p1 > p2:
    p1, p2 = p2, p1
if p3 > p4:
    p3, p4 = p4, p3

if check(p1, p2, p3, p4):
    print(1)
    try:
        x = ((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4))
        y = ((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4))
        print(x, y)
    except:
        if p2 == p3:
            print(p2[0], p2[1])
        elif p1 == p4:
            print(p1[0], p1[1])
else:
    print(0)
