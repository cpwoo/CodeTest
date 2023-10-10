import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
nums = list(map(int, input().split()))

_min = sum(nums)
start, end = max(nums), sum(nums)

while start <= end:
    mid = (start+end)//2
    tot, cnt = 0, 0
    group = []
    for i in range(n):
        if (nums[i]+tot > mid) or (n-i < m-len(group)):
            tot = 0
            group.append(cnt)
            cnt = 0
        tot += nums[i]
        cnt += 1
    
    if cnt: group.append(cnt)

    L = len(group)
    if L == m:
        if _min >= mid:
            _min = mid
            res = group
        end = mid-1
    elif L > m:
        start = mid+1
    else:
        end = mid-1

print(_min)
print(*res)
