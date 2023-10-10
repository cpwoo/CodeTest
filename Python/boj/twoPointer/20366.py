import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted(list(map(int, input().split())))
res = sys.maxsize

for i in range(n):
    for j in range(i+3, n):
        left, right = i+1, j-1
        while left < right:
            tmp = (arr[i]+arr[j])-(arr[left]+arr[right])
            res = min(res, abs(tmp))           
            if tmp < 0:
                right -= 1
            else:
                left += 1

print(res)
