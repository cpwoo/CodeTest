import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted(list(map(int, input().split())))

target = 1

for a in arr:
    if target < a:
        break

    target += a

print(target)
