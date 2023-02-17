import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)])

left, right = arr[0][0], arr[0][1]
answer = 0

for i in range(1, n):
    if right >= arr[i][1]:
        continue
    elif arr[i][0] <= right < arr[i][1]:
        right = arr[i][1]
    elif right < arr[i][0]:
        answer += right-left
        left = arr[i][0]
        right = arr[i][1]

answer += right-left
print(answer)
