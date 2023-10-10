import sys
input = lambda: sys.stdin.readline().rstrip()

n, s = map(int, input().split())
arr = list(map(int, input().split()))
left, right = 0, 0
ans = 100_001
tmp = arr[0]

while True:
    if tmp >= s:
        tmp -= arr[left]
        ans = min(ans, right-left+1)
        left += 1
    else:
        right += 1
        if right == n:
            break
        tmp += arr[right]

print(ans if ans != 100_001 else 0)
