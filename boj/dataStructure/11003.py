import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

N, L = map(int, input().split())
arr = list(map(int, input().split()))
q = deque()
ans = []

for i in range(N):
    while q and q[-1][0] > arr[i]:
        q.pop()
    while q and q[0][1] < i-L+1:
        q.popleft()
    q.append([arr[i], i])
    ans.append(q[0][0])

print(*ans)
