import sys
input = lambda: sys.stdin.readline().rstrip()

strs = input()
stack = []
res='' 

for s in strs:
    if s.isalpha(): #피연산자인지 아닌지 확인
        res += s
    else:
        if s == '(':
            stack.append(s)
        elif s == '*' or s == '/':
            while stack and (stack[-1] == '*' or stack[-1] == '/'):
                res += stack.pop()
            stack.append(s)
        elif s == '+' or s == '-':
            while stack and stack[-1] != '(':
                res += stack.pop()
            stack.append(s)
        elif s == ')':
            while stack and stack[-1] != '(':
                res += stack.pop()
            stack.pop()
      
while stack:
    res += stack.pop()

print(res)
