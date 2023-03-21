import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = int(input()), int(input())
start, end = 0, k
answer = 0
while start <= end:
    mid = (start+end)//2
    count = 0
    for i in range(1, n+1):
        count += min(mid//i, n)
    if count < k:
        start = mid + 1
    else:
        answer = mid
        end = mid - 1

print(answer)
