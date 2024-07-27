import sys
input = lambda: sys.stdin.readline().rstrip()

target = int(input())
n = int(input())
broken = list(map(int, input().split()))

cnt = abs(100-target)

for nums in range(1_000_001):
    nums = str(nums)

    for i in range(len(nums)):
        if int(nums[i]) in broken:
            break

        elif i == len(nums)-1:
            cnt = min(cnt, abs(int(nums)-target)+len(nums))

print(cnt)
