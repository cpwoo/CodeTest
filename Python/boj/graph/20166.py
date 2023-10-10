import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(x, y, cnt, string):
    if cnt > 5:
        return

    if string in ans:
        ans[string] += 1

    for i in range(8):
        nx, ny = (x + n + dx[i]) % n, (y + m + dy[i]) % m
        solve(nx, ny, cnt + 1, string + arr[nx][ny])

n, m, k = map(int, input().split())
ans, arr, res = {}, [], []
dx, dy = [1, 0, -1, 0, 1, 1, -1, -1], [0, 1, 0, -1, -1, 1, 1, -1]
ans_list = []

for _ in range(n):
    arr.append(list(input()))

for _ in range(k):
    data = input()
    ans[data] = 0
    ans_list.append(data)

for i in range(n):
    for j in range(m):
        start = ''
        solve(i, j, 1, start + arr[i][j])

for k in ans_list:
    if k in ans:
        print(ans[k])
