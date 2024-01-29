import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = []
for _ in range(n):
    x, y = map(int, input().split())
    arr.append(y)

stk = []
cnt = 0
for i in range(n):
    while stk and arr[i] < stk[-1]:
        if stk[-1] != 0:
            cnt += 1
        stk.pop()
    if stk and arr[i] == stk[-1]:
        continue
    stk.append(arr[i])

while stk:
    if stk[-1] != 0:
        cnt += 1
    stk.pop()

print(cnt)
