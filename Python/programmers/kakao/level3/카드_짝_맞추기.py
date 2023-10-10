from collections import deque

directions = ((1, 0), (-1, 0), (0, 1), (0, -1))

def ctrl_move(y, x, dy, dx, board):
    ny, nx = y+dy, x+dx
    if (0 <= ny < 4) and (0 <= nx < 4):
        if board[ny*4+nx] == "0":
            return ctrl_move(ny, nx, dy, dx, board)
        else:
            return ny, nx
    else:
        return y, x

def solution(board, r, c):
    answer = 0
    board = "".join(str(each) for row in board for each in row)
    q = deque([(r, c, 0, -1, board)]) # bfs, y, x, count, enter, board
    visited = set()
    while q:
        y, x, count, enter, board = q.popleft()
        if board.count("0") == 16:
            return count
        if (y, x, enter, board) in visited:
            continue
        visited.add((y, x, enter, board))

        for dy, dx in directions:
            ny, nx = y+dy, x+dx
            if (0 <= ny < 4) and (0 <= nx < 4):
                q.append((ny, nx, count+1, enter, board))
            ny, nx = ctrl_move(y, x, dy, dx, board)
            if (ny, nx) == (y, x):
                continue
            q.append((ny, nx, count+1, enter, board))
        position = y*4+x

        if board[position] != 0:
            if enter == -1:
                q.append((y, x, count+1, position, board))
            elif enter != position and board[enter] == board[position]:
                board = board.replace(board[enter], "0")
                q.append((y, x, count+1, -1, board))
    return answer


board = [[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]]
r, c = 1, 0
print(solution(board, r, c)) # 14

board = [[3,0,0,2],[0,0,1,0],[0,1,0,0],[2,0,0,3]]
r, c = 0, 1
print(solution(board, r, c)) # 16
