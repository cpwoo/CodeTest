import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]
fr, to = map(int, input().split())

if (fr-to)%n in [1, n-1]:
    print(2)
    print(fr, to)
    exit()

flag = False
if (fr == 0) or (to != 0 and fr > to):
    flag = True
    fr, to = to, fr

stack = []
for i in range(fr, fr+n):
    i %= n
    while len(stack) > 1:
        if ccw(points[stack[-2]], points[stack[-1]], points[i]) < 0:
            break
        stack.pop()
    stack.append(i)
    
    if i == to:
        break

if flag:
    stack.reverse()

print(len(stack))
print(*stack)
