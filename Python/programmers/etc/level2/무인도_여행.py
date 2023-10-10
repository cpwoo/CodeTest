from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(x, y, row, col, visited, maps):
    q = deque()
    q.append([x, y])
    visited[x][y] = 1
    cost = int(maps[x][y])
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if (0 <= nx < row) and (0 <= ny < col) and not visited[nx][ny] and maps[nx][ny] != "X":
                cost += int(maps[nx][ny])
                q.append([nx, ny])
                visited[nx][ny] = 1
    return visited, cost

def solution(maps):
    answer = []
    row, col = len(maps), len(maps[0])
    visited = [[0]*col for _ in range(row)]
    for i in range(row):
        for j in range(col):
            if not visited[i][j] and maps[i][j] != "X":
                visited, cost = bfs(i, j, row, col, visited, maps)
                answer.append(cost)
    return sorted(answer) if answer else [-1]


maps = ["X591X","X1X5X","X231X", "1XXX1"]
print(solution(maps)) # [1, 1, 27]

maps = ["XXX","XXX","XXX"]
print(solution(maps)) # [-1]
