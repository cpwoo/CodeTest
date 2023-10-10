import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
lst = sorted(list(map(int, input().split())))
result = sys.maxsize
answer = []

for i in range(n-2):
    left, right = i+1, n-1
    while left < right:
        tmp = lst[i] + lst[left] + lst[right]
        if abs(tmp) <= abs(result):
            answer = [lst[i], lst[left], lst[right]]
            result = tmp
        if tmp < 0:
            left += 1
        elif tmp > 0:
            right -= 1
        else:
            print(*answer)
            break

print(*answer)
