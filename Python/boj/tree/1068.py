import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))
k = int(input())

def dfs(x):
    arr[x] = -2
    for i in range(n):
        if x == arr[i]:
            dfs(i)

dfs(k)
cnt = 0
for i in range(n):
    if arr[i] != -2 and i not in arr:
        cnt += 1

print(cnt)
