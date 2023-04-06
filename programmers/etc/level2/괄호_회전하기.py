def check(s):
    stack = []
    for i in range(len(s)):
        if not stack:
            stack.append(s[i])
        else:
            stack.append(s[i])
            p, q = stack[-2], stack[-1]
            if (p, q) == ('(', ')') or (p, q) == ('{', '}') or (p, q) == ('[', ']'):
                stack.pop()
                stack.pop()
    return len(stack) == 0
        
def solution(s):
    answer = 0
    if check(s):
        answer += 1
    for _ in range(len(s)-1):
        s = s[1:] + s[0]
        if check(s):
            answer += 1
    return answer


s = "[](){}"
print(solution(s)) # 3

s = "}]()[{"
print(solution(s)) # 2

s = "[)(]"
print(solution(s)) # 0

s = "}}}"
print(solution(s)) # 0
