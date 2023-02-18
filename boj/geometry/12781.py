import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(x1, y1, x2, y2, x3, y3):
    result = x1*y2 + x2*y3 + x3*y1 - (y1*x2 + y2*x3 + y3*x1)
    return 0 if result == 0 else result // abs(result)

x1, y1, x2, y2, x3, y3, x4, y4 = map(int, input().split())

ans1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4)
ans2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2)

print(1 if (ans1, ans2) == (-1, -1) else 0)
