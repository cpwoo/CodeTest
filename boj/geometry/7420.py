import sys
input = lambda: sys.stdin.readline().rstrip()

from math import pi

def dist(p1, p2):
    return ((p1[0]-p2[0])**2+(p1[1]-p2[1])**2)**0.5

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


N, L = map(int, input().split())
points = sorted([list(map(int, input().split())) for _ in range(N)])

if N == 2:
    print(round(dist(points[0], points[1])) + 2*L)
    exit()

stack = []
for i in range(N):
    while len(stack) >= 2:
        if ccw(stack[-2], stack[-1], points[i]) == 1:
            break
        stack.pop()
    stack.append(points[i])

reverse_stack = []
for i in range(N-1, -1, -1):
    while len(reverse_stack) >= 2:
        if ccw(reverse_stack[-2], reverse_stack[-1], points[i]) == 1:
            break
        reverse_stack.pop()
    reverse_stack.append(points[i])

cvxh = stack[:-1] + reverse_stack[:-1]
c = len(cvxh)

ans = 0
for i in range(c):
    ans += dist(cvxh[i%c], cvxh[(i+1)%c])

print(round(ans+2*pi*L))
