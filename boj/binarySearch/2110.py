import sys
input = lambda: sys.stdin.readline().rstrip()

n, c = map(int, input().split())
house = sorted([int(input()) for _ in range(n)])

start, end = 1, house[-1]-house[0]
result = 0

while start <= end:
    mid = (start+end)//2
    old = house[0]
    cnt = 1
    
    for i in range(1, len(house)):
        if house[i] >= old+mid:
            cnt += 1
            old = house[i]

    if cnt >= c:
        start = mid+1
        result = mid
    else:
        end = mid-1

print(result)
