import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

n, m = map(int, input().split())
a = dict()
for _ in range(m):
    a[int(input())] = 1

# (141*142)/2 = 10011 > 10000
dp = [[INF]*142 for _ in range(n+1)]
dp[1][0] = 0

for i in range(2, n+1):
    if a.get(i): continue
    v = 1
    while v*(v+1) <= 2*i:
        dp[i][v] = min(dp[i-v][v-1], dp[i-v][v], dp[i-v][v+1])+1
        v += 1

answer = min(dp[n])
print(answer if answer != INF else -1)
