def solution(board):
    
    def check(board, st):
        for i in range(3):
            if all(board[i][j] == st for j in range(3)):
                return 1
        for j in range(3):
            if all(board[i][j] == st for i in range(3)):
                return 1
        for i in range(3):
            if all(board[i][i] == st for i in range(3)):
                return 1
            elif all(board[i][2-i] == st for i in range(3)):
                return 1
        return 0
    
    o, x = 0, 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == "O":
                o += 1
            elif board[i][j] == "X":
                x += 1
    if o < x or o > x+1:
        return 0
    
    winO, winX = check(board, "O"), check(board, "X")
    
    if winO and winX:
        return 0
    if winO and not winX and o == x:
        return 0
    if not winO and winX and o != x:
        return 0
    else:
        return 1
    

board = ["O.X", ".O.", "..X"]
print(solution(board)) # 1

board = ["OOO", "...", "XXX"]
print(solution(board)) # 0

board = ["...", ".X.", "..."]
print(solution(board)) # 0

board = ["...", "...", "..."]
print(solution(board)) # 1
