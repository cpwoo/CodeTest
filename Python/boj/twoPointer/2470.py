import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted(list(map(int, input().split())))
left, right = 0, n-1
answer = int(1e10)
ans_left, ans_right = 0, 0

while left < right:
    tmp = arr[left] + arr[right]

    if abs(tmp) < answer:
        answer = abs(tmp)
        ans_left, ans_right = arr[left], arr[right]

    if tmp < 0:
        left += 1
    else:
        right -= 1

print(ans_left, ans_right)
