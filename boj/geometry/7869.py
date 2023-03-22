import sys
input = lambda: sys.stdin.readline().rstrip()

import math

x1, y1, r1, x2, y2, r2 = map(float, input().split())
d = math.sqrt((x2-x1)**2 + (y2-y1)**2) 

if d == 0:
    result = min(math.pi * r1*r1, math.pi * r2*r2)
elif d > r1+r2:
    result = 0
elif (d <= abs(r1-r2) and r1 < r2):
    result = math.pi * r1 * r1
elif (d <= abs(r1-r2) and r1 > r2):
    result = math.pi * r2 * r2
else:
    theta1 = (math.acos((r1*r1 + d*d - r2*r2) / (2*r1*d))) * 2
    theta2 = (math.acos((r2*r2 + d*d - r1*r1) / (2*r2*d))) * 2
    result = 0.5 * (r1*r1 * (theta1 - math.sin(theta1)) + r2*r2 * (theta2 - math.sin(theta2)))

print('%.3f' % result)
