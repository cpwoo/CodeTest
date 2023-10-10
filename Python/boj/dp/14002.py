import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
dp = [1]*n

# 최대 길이
for i in range(1, n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))

# 부분 수열 출력
order = max(dp)
lst = []
for i in range(n-1, -1, -1):
    if dp[i] == order:
        lst.append(arr[i])
        order -= 1
lst = lst[::-1]
print(*lst)
