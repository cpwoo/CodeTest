from collections import deque
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def move(pos, arr):
    nxt = []
    pos = list(pos)
    x1, y1, x2, y2 = pos[0][0], pos[0][1], pos[1][0], pos[1][1]

    for i in range(4):
        nx1, ny1, nx2, ny2 = x1+dx[i], y1+dy[i], x2+dx[i], y2+dy[i]
        if (arr[nx1][ny1], arr[nx2][ny2]) == (0, 0):
            nxt.append({(nx1, ny1), (nx2, ny2)})

    if x1 == x2:
        for i in [-1, 1]:
            if (arr[x1+i][y1], arr[x2+i][y2]) == (0, 0):
                nxt.append({(x1, y1), (x1+i, y1)})
                nxt.append({(x2, y2), (x2+i, y2)})
    
    if y1 == y2:
        for i in [-1, 1]:
            if (arr[x1][y1+i], arr[x2][y2+i]) == (0, 0):
                nxt.append({(x1, y1), (x1, y1+i)})
                nxt.append({(x2, y2), (x2, y2+i)})

    return nxt

def solution(board):
    n = len(board)
    arr = [[1]*(n+2) for _ in range(n+2)]
    for i in range(n):
        for j in range(n):
            arr[i+1][j+1] = board[i][j]
    q = deque()
    visited = []
    pos = {(1, 1), (1, 2)}
    q.append((pos, 0))
    visited.append(pos)
    while q:
        pos, cost = q.popleft()
        if (n, n) in pos:
            return cost
        for nxt in move(pos, arr):
            if nxt not in visited:
                q.append((nxt, cost+1))
                visited.append(nxt)
    return 0


board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
print(solution(board)) # 7
