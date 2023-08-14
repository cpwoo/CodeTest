import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
A = list(map(int, input().split()))

Q = int(input())
L = list(map(int, input().split()))

dp = [0]*100001
for a in A:
    dp[a] += 1

for j in range(1, 100001):
    for i in range(2*j, 100001, j):
        dp[i] += dp[j]

print(*(dp[i] for i in L))
