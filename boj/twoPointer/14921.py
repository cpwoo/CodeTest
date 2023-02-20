n = int(input())
arr = list(map(int, input().split()))

left, right = 0, n-1

ans = arr[left] + arr[right]

while left < right:
    tmp = arr[left] + arr[right]
    if abs(ans) > abs(tmp):
        ans = tmp
    
    if tmp < 0:
        left += 1
    else:
        right -= 1

print(ans)
