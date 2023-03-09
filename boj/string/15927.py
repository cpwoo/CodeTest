import sys
input = lambda: sys.stdin.readline().rstrip()

def check(left, right):
    while left < right:
        if s[left] != s[right]:
            return 0
        left += 1
        right -= 1
    return 1

s = input()
n = len(s)

if not check(0, n-1):
    print(n)
elif not check(0, n-2):
    print(n-1)
else:
    print(-1)
