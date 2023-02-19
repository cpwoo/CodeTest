import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

n, k = map(int, input().split())
q = deque()
q.append(n)
visited = [-1] * 100001
visited[n] = 0

while q:
    s = q.popleft()
    if s == k:
        print(visited[s])
        break
    if (0 <= s-1 < 100001) and visited[s-1] == -1:
        visited[s-1] = visited[s] + 1
        q.append(s-1)
    if (0 < s*2 < 100001) and visited[s*2] == -1:
        visited[s*2] = visited[s]
        q.append(s*2)
    if (0 <= s+1 < 100001) and visited[s+1] == -1:
        visited[s+1] = visited[s] + 1
        q.append(s+1)
