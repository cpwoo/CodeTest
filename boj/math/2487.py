import sys
input = lambda: sys.stdin.readline().rstrip()

from math import lcm

n = int(input())
arr = [0] + list(map(int, input().split()))
visited = [0]*(n+1)

ans = 1
for i in range(1, n+1):
    if not visited[i]:
        visited[i] = 1
        k = 1
        j = arr[i]
        while j != i:
            visited[j] = 1
            j = arr[j]
            k += 1
    ans = lcm(ans, k)

print(ans)
