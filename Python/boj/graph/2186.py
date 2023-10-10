import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def dfs(x, y, idx):
    if idx == len(word):
        return 1
    if visited[x][y][idx] != -1:
        return visited[x][y][idx]
    
    visited[x][y][idx] = 0

    for d in range(4):
        tx, ty = x, y
        for _ in range(k):
            nx, ny = tx+dx[d], ty+dy[d]
            if (0 <= nx < n) and (0 <= ny < m):
                if arr[nx][ny] == word[idx]:
                    visited[x][y][idx] += dfs(nx, ny, idx+1)
            tx, ty = nx, ny
    
    return visited[x][y][idx]


n, m, k = map(int, input().split())
arr = [list(input()) for _ in range(n)]
word = input()

start = []
for i in range(n):
    for j in range(m):
        if arr[i][j] == word[0]:
            start.append([i, j])

ans = 0
visited = [[[-1]*len(word) for _ in range(m)] for _ in range(n)]

for x, y in start:
    ans += dfs(x, y, 1)

print(ans)
