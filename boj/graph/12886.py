import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import permutations

def answer(x, y, z, cnt):
    global ans
    if x <= 0 and y <= 0 and z <= 0:
        if ans > cnt:
            ans = cnt
        return
    
    x = 0 if x <= 0 else x
    y = 0 if y <= 0 else y
    z = 0 if z <= 0 else z

    if dp[x][y][z] <= cnt and dp[x][y][z] != 0:
        return
    
    dp[x][y][z] = cnt

    for i in permutations([9, 3, 1], 3):
        answer(x-i[0], y-i[1], z-i[2], cnt+1)


N = int(input())
a = list(map(int, input().split()))
while len(a) < 3:
    a += [0]
ans = 100
dp = [[[100]*(max(a)+1) for _ in range(max(a)+1)] for _ in range(max(a)+1)]
answer(a[0], a[1], a[2], 0)
print(ans)
