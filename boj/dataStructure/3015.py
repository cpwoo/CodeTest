import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [int(input()) for _ in range(n)]

stack = []
result = 0

for a in arr:
    while stack and stack[-1][0] < a:
        result += stack.pop()[1]

    if not stack:
        stack.append([a, 1])
        continue

    if stack[-1][0] == a:
        cnt = stack.pop()[1]
        result += cnt

        if stack:
            result += 1
        stack.append([a, cnt+1])
    
    else:
        stack.append([a, 1])
        result += 1

print(result)
