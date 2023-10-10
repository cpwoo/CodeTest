import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    q = deque()
    visited = [[0]*n for _ in range(n)]
    q.append([0, 0])
    visited[0][0] = 1
    while q:
        x, y = q.popleft()
        if (x, y) == (n-1, n-1):
            return 1
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < n) and (0 <= ny < n) and left <= graph[nx][ny] <= right and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append([nx, ny])
    return 0


n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

l_min, r_max = 200, 0
for i in range(n):
    for j in range(n):
        l_min = min(l_min, graph[i][j])
        r_max = max(r_max, graph[i][j])

l_max, r_min = graph[0][0], graph[-1][-1]
if l_max > r_min:
    l_max, r_min = r_min, l_max

left, right = l_min, r_min
ans = sys.maxsize

while (l_min <= left <= l_max) and (r_min <= right <= r_max):
    l_flag, r_flag = 0, 0
    if bfs():
        ans = min(ans, right-left)
        left += 1
        l_flag += 1
    else:
        if l_flag and r_flag:
            left += 1
            right += 1
        else:
            right += 1
            r_flag += 1

print(ans)
