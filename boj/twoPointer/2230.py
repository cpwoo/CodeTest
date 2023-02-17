import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = sorted([int(input()) for _ in range(N)])

left, right = 0, 0
ans = int(2e9)+1

while left < N and right < N:
    tmp = arr[right] - arr[left]

    if tmp == M:
        print(M)
        exit()
    
    if tmp < M:
        right += 1
        continue
    left += 1
    ans = min(ans, tmp)

print(ans)
