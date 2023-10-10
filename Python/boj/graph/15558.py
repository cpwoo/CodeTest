import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n, k = map(int, input().split())
lines = [list(map(int, input())) for _ in range(2)]

q = deque()
q.append((0, 0))
visited = [[0]*n for _ in range(2)]

time = -1
flag = False
while q:
    for _ in range(len(q)):
        d, idx = q.popleft()
        if idx+1 >= n or idx+k >= n:
            flag = True
            break
        if lines[d][idx+1] and not visited[d][idx+1]:
            q.append((d, idx+1))
            visited[d][idx+1] = 1
        if idx-1 > time+1 and lines[d][idx-1] and not visited[d][idx-1]:
            q.append((d, idx-1))
            visited[d][idx-1] = 1
        if lines[(d+1)%2][idx+k] and not visited[0][idx+k]:
            q.append(((d+1)%2, idx+k))
            visited[(d+1)%2][idx+k] = 1
    time += 1

print(1 if flag else 0)
