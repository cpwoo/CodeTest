import sys
input = lambda: sys.stdin.readline().rstrip()

c, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda t: t[0])
cost = [int(1e9)]*(c+100)
cost[0] = 0

for pay, profit in arr:
    for i in range(profit, c+100):
        cost[i] = min(cost[i-profit]+pay, cost[i])

print(min(cost[c:]))
