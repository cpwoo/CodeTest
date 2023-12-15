import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

n, m = map(int, input().split())
arr = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda t: (t[1], -t[0]))

ans = INF
amount, price = 0, 0
flag = False

for i in range(n):
    amount += arr[i][0]
    if i-1 >= 0 and arr[i][1] == arr[i-1][1]:
        price += arr[i][1]
    else:
        price = arr[i][1]
    if amount >= m:
        ans = min(ans, price)
        flag = True

print(ans if flag else -1)
