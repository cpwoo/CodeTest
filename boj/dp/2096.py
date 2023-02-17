import sys
input = lambda: sys.stdin.readline().rstrip()

# 메모리 제한이 4MB 임을 유의할 것 (int 4KB 이므로 1e6 까지만 허용)

n = int(input())

max_dp = [0]*3
min_dp = [0]*3

max_tmp = [0]*3
min_tmp = [0]*3

for i in range(n):
    a, b, c = map(int, input().split())
    for j in range(3):
        if j == 0:
            max_tmp[j] = a + max(max_dp[j], max_dp[j+1])
            min_tmp[j] = a + min(min_dp[j], min_dp[j+1])
        elif j == 1:
            max_tmp[j] = b + max(max_dp[j-1], max_dp[j], max_dp[j+1])
            min_tmp[j] = b + min(min_dp[j-1], min_dp[j], min_dp[j+1])
        else:
            max_tmp[j] = c + max(max_dp[j-1], max_dp[j])
            min_tmp[j] = c + min(min_dp[j-1], min_dp[j])

    for j in range(3):
        max_dp[j] = max_tmp[j]
        min_dp[j] = min_tmp[j]

print(max(max_dp), min(min_dp))
