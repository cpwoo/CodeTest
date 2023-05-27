import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


for _ in range(int(input())):
    n = int(input())
    arr = []
    for _ in range(ceil(n/5)):
        arr.extend(list(map(int, input().split())))
    points = sorted([[arr[i], arr[i+1]] for i in range(0, 2*n, 2)], key=lambda t: (-t[1], t[0]))

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

    cvxh = reverse_stack[-1:0:-1] + stack[-1:0:-1]

    print(len(cvxh))
    for c in cvxh:
        print(*c)
