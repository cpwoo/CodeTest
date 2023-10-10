import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dr = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def bfs(start):
    q = deque()
    q.append(start)
    ans = 1
    time = True

    while q:
        for _ in range(len(q)):
            i, j, w = q.popleft()

            if (i, j) == (n-1, m-1):
                return ans
            
            for dx, dy in dr:
                ni, nj = i+dy, j+dx
                if ni < 0 or ni >= n or nj < 0 or nj >= m or visited[ni][nj] <= w:
                    continue
                if graph[ni][nj] == '0':
                    q.append([ni, nj, w])
                    visited[ni][nj] = w
                elif w < k:
                    if not time:
                        q.append([i, j, w])
                    else:
                        visited[ni][nj] = w
                        q.append([ni, nj, w+1])
        ans += 1
        time = not time
    return -1

n, m, k = map(int, input().split())
graph = [input() for _ in range(n)]
visited = [[k+1 for _ in range(m)] for _ in range(n)]
visited[0][0] = 0

print(bfs([0, 0, 0]))
