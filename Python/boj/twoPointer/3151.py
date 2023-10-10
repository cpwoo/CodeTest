import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import Counter

n = int(input())
arr = sorted(list(map(int, input().split())))
cnt_ = Counter(arr)
res = 0

for i in range(len(arr)):
    left, right = i+1, n-1
    while left < right:
        sum_ = arr[left] + arr[right] + arr[i]
        if sum_ == 0:
            if arr[left] == arr[right]:
                res += right-left
            else:
                res += cnt_[arr[right]]
            left += 1
        elif sum_ > 0:
            right -= 1
        else:
            left += 1
            
print(res)
