def solution(s):
    stack = []
    for i in s:
        if stack and stack[-1] == i:
            stack.pop()
        else:
            stack.append(i)

    return 1 if not stack else 0


s = "baabaa"
print(solution(s)) # 1

s = "cdcd"
print(solution(s)) # 0
