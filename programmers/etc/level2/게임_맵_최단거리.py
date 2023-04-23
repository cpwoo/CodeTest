from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def solution(maps):
    n, m = len(maps), len(maps[0])
    visited = [[0]*m for _ in range(n)]
    visited[0][0] = 1
    q = deque([[0, 0]])
    
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < n) and (0 <= ny < m) and not visited[nx][ny] and maps[nx][ny]:
                visited[nx][ny] = visited[x][y]+1
                q.append([nx, ny])
    
    return visited[n-1][m-1] if visited[n-1][m-1] else -1


maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
print(solution(maps)) # 11

maps = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]
print(solution(maps)) # -1
