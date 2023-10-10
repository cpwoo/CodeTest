import sys
input = lambda: sys.stdin.readline().rstrip()

def recur(cur):
    global ans
    if cur == r:
        ans = max(ans, int("".join(num)))
        return
    for i in range(len(num)-1):
        for j in range(i+1, len(num)):
            num[i], num[j] = num[j], num[i]
            a = "".join(num)
            if visited.get((a, cur), 1):
                visited[(a, cur)] = 0
                recur(cur + 1)
            num[i], num[j] = num[j], num[i]


num, r = input().split()
num, r = list(num), int(r)
visited = {}
ans = -1

if len(num) == 1 or (len(num) == 2 and '0' in num):
    pass
else:
    recur(0)

print(ans)
