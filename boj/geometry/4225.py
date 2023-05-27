import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil

INF = sys.maxsize

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)

cnt = 1
while True:
    n = int(input())
    if n == 0:
        break
    points = sorted([list(map(int, input().split())) for _ in range(n)])

    stack = []
    for i in range(n):
        while len(stack) > 1:
            if ccw(stack[-2], stack[-1], points[i]) > 0:
                break
            stack.pop()
        stack.append(points[i])

    reverse_stack = []
    for i in range(n-1, -1, -1):
        while len(reverse_stack) > 1:
            if ccw(reverse_stack[-2], reverse_stack[-1], points[i]) > 0:
                break
            reverse_stack.pop()
        reverse_stack.append(points[i])
    
    cvxh = stack[:-1] + reverse_stack[:-1]
    
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

    print("Case %d: %.2f" %(cnt, ceil(d*100)/100))
    cnt += 1
