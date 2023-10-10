import sys
input = lambda: sys.stdin.readline().rstrip()

def calc(x1, y1, x2, y2):
    return (y2-y1)/(x2-x1)

n = int(input())
arr = list(map(int, input().split()))
ans = 0

for idx, a in enumerate(arr):
    tmp = 0
    left = 1e9
    right = -1e9

    for i in range(idx-1, -1, -1):
        c = calc(idx+1, a, i+1, arr[i])
        if c < left:
            left = c
            tmp += 1

    for i in range(idx+1, n):
        c = calc(idx+1, a, i+1, arr[i])
        if c > right:
            right = c
            tmp += 1
    
    ans = max(ans, tmp)

print(ans)
