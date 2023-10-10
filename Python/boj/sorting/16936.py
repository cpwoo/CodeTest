import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

ans = []
for a in arr:
    cnt = 0
    tmp = a
    while True:
        if tmp%3 == 0:
            cnt += 1
            tmp //= 3
        else:
            break
    ans.append([cnt, a])

ans.sort(key = lambda t: (-t[0], t[1]))
print(*map(lambda t: t[1], ans))
