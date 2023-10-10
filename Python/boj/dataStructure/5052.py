import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n = int(input())
    nums = sorted([input() for _ in range(n)])
    flag = True
    for i in range(n-1):
        long = len(nums[i])
        if nums[i] == nums[i+1][:long]:
            flag = False
            break
    print("YES" if flag else "NO")
