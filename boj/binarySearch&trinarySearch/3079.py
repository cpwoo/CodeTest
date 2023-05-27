import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
time = sorted([int(input()) for _ in range(n)])

start, end = 0, min(time) * m
result = 0

while start <= end:
    mid = (start+end)//2
    total = 0
    for t in time:
        total += mid // t
    
    if total >= m:
        end = mid-1
        result = mid
    else:
        start = mid+1
    
print(result)
