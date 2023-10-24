import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = []
arr.append((0,0,0,0))

for i in range(1, n+1):
    a, h, m = map(int, input().split())
    arr.append((i, a, h, m))
arr = sorted(arr, key=lambda t: t[3])

dp = [0]*(n+1)

for i in range(1, n+1):
    for j in range(i):
        if arr[j][1] < arr[i][1]:
            dp[i] = max(dp[i], dp[j]+arr[i][2])

m = max(dp)
idx = dp.index(m)
ret = []

while idx != 0:
    if m == dp[idx]:
        ret.append(arr[idx][0])
        m -= arr[idx][2]
    idx -= 1

print(len(ret))
print(*ret[::-1], sep='\n')
