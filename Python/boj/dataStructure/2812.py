import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
s = list(input())
stack = []
cnt = 0
for i in range(n):
    while cnt < k and stack and stack[-1] < s[i]:
        stack.pop()
        cnt += 1
    stack.append(s[i])
    
print(''.join(stack[:n-k]))
