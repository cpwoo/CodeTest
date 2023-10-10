import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n = int(input())
d = [[-1]*(n+1) for _ in range(n+1)]
q = deque()
q.append([1, 0])
d[1][0] = 0

while q:
    s, c = q.popleft()
    if d[s][s] == -1:
        d[s][s] = d[s][c] + 1
        q.append([s, s])
    
    if s+c <= n and d[s+c][c] == -1:
        d[s+c][c] = d[s][c] + 1
        q.append([s+c, c])
    if s-1 >= 0 and d[s-1][c] == -1:
        d[s-1][c] = d[s][c] + 1
        q.append([s-1, c])

answer = -1
for i in range(n+1):
    if d[n][i] != -1:
        if answer == -1 or answer > d[n][i]:
            answer = d[n][i]

print(answer)
