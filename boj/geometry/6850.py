import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    return (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])


n = int(input())
points = sorted([list(map(int, input().split())) for _ in range(n)])

stack = []
for i in range(n):
    while len(stack) > 1:
        if ccw(stack[-2], stack[-1], points[i]) > 0:
            break
        p = stack.pop()
    stack.append(points[i])

reverse_stack = []
for i in range(n-1, -1, -1):
    while len(reverse_stack) > 1:
        if ccw(reverse_stack[-2], reverse_stack[-1], points[i]) > 0:
            break
        reverse_stack.pop()
    reverse_stack.append(points[i])

cvxh = stack[:-1] + reverse_stack[:-1]

ret = 0
for i in range(1, len(cvxh)-1):
    ret += ccw(cvxh[0], cvxh[i], cvxh[i+1])

print(ret//100)
