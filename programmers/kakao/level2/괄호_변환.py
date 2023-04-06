def solution(p):

    def split(arr):
        u = ""
        v = list(arr[::-1])
        d = [0, 0]
        for a in arr:
            u += a
            v.pop()
            if a == "(":
                d[0] += 1
            else:
                d[1] += 1
            if d[0] == d[1]:
                break
        v = "".join(v[::-1])
        return u, v

    def check(u):
        stack = []
        for i in u:
            if i == "(":
                stack.append(i)
            else:
                if stack and stack[-1] == "(":
                    stack.pop()
                else:
                    stack.append(i)
        return not stack
    
    def flip(u):
        ret = ""
        for i in u:
            if i == "(":
                ret += ")"
            elif i == ")":
                ret += "("
        return ret

    if p == "":
        return p
    
    u, v = split(p)
    
    if check(u):
        u += solution(v)
        return u
    else:
        st = "(" + solution(v) + ")" + flip(u[1:-1])
        return st


p = "(()())()"
print(solution(p)) # "(()())()"

p = ")("
print(solution(p)) # "()"

p = "()))((()"
print(solution(p)) # "()(())()"
