import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
circle = []

for i in range(n):
    x, r = map(int, input().split())
    circle.append([x-r, i])
    circle.append([x+r, i])

circle.sort()

stack = []
for i in range(n*2):
    d, c = circle[i]
    if not stack:
        stack.append(circle[i])
    else:
        if stack[-1][1] == c:
            stack.pop()
        else:
            stack.append(circle[i])

print("YES" if not stack else "NO")
