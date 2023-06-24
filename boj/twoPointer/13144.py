import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

dp = [0]*100001
end = 0
cnt = 0

for i in range(n):
    while end < n:
        if dp[arr[end]]:
            break
        dp[arr[end]] = 1
        end += 1
    cnt += end-i
    dp[arr[i]] = 0

print(cnt)
