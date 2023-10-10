import sys
input = lambda: sys.stdin.readline().rstrip()

MAX = 1_000_000
dp = [0]*(MAX+1)
s = [0]*(MAX+1)

for i in range(1, MAX+1):
    j = 1
    while i*j <= MAX:
        dp[i*j] += i
        j += 1
    s[i] = s[i-1] + dp[i]


for _ in range(int(input())):
    t = int(input())
    print(s[t])
