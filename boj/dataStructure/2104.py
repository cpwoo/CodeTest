import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
nums = list(map(int, input().split()))
stack = []
ans = 0

for idx, num in enumerate(nums):
    w = 0
    while stack and stack[-1][0] > num:
        h, cur_w = stack.pop()
        ans = max(ans, h*(cur_w+w))
        w += cur_w
    stack.append([num, num+w])

w = 0
while stack:
    h, cur_w = stack.pop()
    ans = max(ans, h*(cur_w+w))
    w += cur_w

print(ans)
