def solution(s):
    stack = []
    for i in s:
        if i == "(":
            stack.append(i)
        else:
            if stack and stack[-1] == "(":
                stack.pop()
            else:
                stack.append(")")
    return len(stack) == 0


s = "()()"
print(solution(s)) # True

s = "(())()"
print(solution(s)) # True

s = ")()("
print(solution(s)) # False

s = "(()("
print(solution(s)) # False
