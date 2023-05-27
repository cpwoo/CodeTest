import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n, px, py = map(int, input().split())
p = [px, py]
points = [list(map(int, input().split())) for _ in range(n)]

ans = 0
while len(points) >= 3:
    points.sort()
    stack = []
    for pt in points:
        while len(stack) > 1:
            if ccw(stack[-2], stack[-1], pt) >= 0:
                break
            stack.pop()
        stack.append(pt)

    reverse_stack = []
    for pt in points[::-1]:
        while len(reverse_stack) > 1:
            if ccw(reverse_stack[-2], reverse_stack[-1], pt) >= 0:
                break
            reverse_stack.pop()
        reverse_stack.append(pt)
    
    cvxh = stack[:-1] + reverse_stack[:-1]

    flag = True
    for i in range(len(cvxh)):
        ni = (i+1)%len(cvxh)
        if ccw(cvxh[i], cvxh[ni], p) <= 0:
            flag = False
            break
    
    if not flag: break
    ans += 1

    for c in cvxh:
        points.remove(c)

print(ans)
