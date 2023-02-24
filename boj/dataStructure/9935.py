import sys
input = lambda: sys.stdin.readline().rstrip()

s, p = input(), input()

stack = []

for i in range(len(s)):
    stack.append(s[i])
    if s[i] == p[-1] and ''.join(stack[-len(p):]) == p:
        del stack[-len(p):]

print(''.join(stack) if len(stack) != 0 else "FRULA")
