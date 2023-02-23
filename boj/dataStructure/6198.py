import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [int(input()) for _ in range(n)]

stack = []
result = 0

for a in arr:
    while stack and stack[-1] <= a:
        stack.pop()
    stack.append(a)

    result += len(stack)-1

print(result)
