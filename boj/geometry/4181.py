import sys
input = lambda: sys.stdin.readline().rstrip()

# cvxh 각 선분 사이의 점 역시 출력해야 한다. (ccw > 0 -> ccw >= 0) 으로 변경

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n = int(input())
points = []
for _ in range(n):
    x, y, flag = input().split()
    x, y = map(int, [x, y])
    if flag == "Y":
        points.append([x, y])
points.sort()

n = len(points)
stack = []
for i in range(n):
    while len(stack) > 1:
        if ccw(stack[-2], stack[-1], points[i]) >= 0:
            break
        stack.pop()
    stack.append(points[i])

reverse_stack = []
for i in range(n-1, -1, -1):
    while len(reverse_stack) > 1:
        if ccw(reverse_stack[-2], reverse_stack[-1], points[i]) >= 0:
            break
        reverse_stack.pop()
    reverse_stack.append(points[i])

cvxh = stack[:-1] + reverse_stack[:-1]

print(len(cvxh))
for x, y in cvxh:
    print(f"{x} {y}")
