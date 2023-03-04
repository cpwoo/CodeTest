import sys
input = lambda: sys.stdin.readline().rstrip()

def dist(p1, p2):
    return ((p1[0]-p2[0])**2+(p1[1]-p2[1])**2)**0.5

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


c = int(input())
points = sorted([list(map(int, input().split())) for _ in range(c)])

if c == 2:
    print(dist(points[0], points[1]))
    exit()

# convex hull 아래부분
stack = []
for i in range(c):
    while len(stack) >= 2:
        if ccw(stack[-2], stack[-1], points[i]) == 1:
            break
        stack.pop()
    stack.append(points[i])

# convex hull 윗부분
reverse_stack = []
for i in range(c-1, -1, -1):
    while len(reverse_stack) >= 2:
        if ccw(reverse_stack[-2], reverse_stack[-1], points[i]) == 1:
            break
        reverse_stack.pop()
    reverse_stack.append(points[i])

# 양 끝 점이 겹치기 때문에 하나씩 빼준다.
cvxh = stack[:-1] + reverse_stack[:-1]

# 회전하는 캘리퍼스
# 이렇게 할 수도 있지만 시간 단축을 더 하고 싶으면 left, right 설정 후 돌리면 된다.
_max = 0
for a in cvxh:
    for b in cvxh:
        _max = max(_max, dist(a, b))

print(_max)
