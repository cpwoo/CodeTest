def solution(board):
    n = len(board)
    answer = 0
    cnt = 0
    black = []
    
    while cnt <= 2:
        cnt += 1
        for col in range(n):
            idx = 0
            while True:
                if board[0][col] != 0:
                    break
                if idx >= n-1:
                    board[idx][col] = -1
                    black.append([idx, col])
                    break
                if board[idx+1][col] != 0:
                    board[idx][col] = -1
                    black.append([idx, col])
                    break
                idx += 1
        
        for row in range(n-1):
            for col in range(n-2):
                block = []
                if board[row][col] != 0:
                    for p in range(row, row+2):
                        for q in range(col, col+3):
                            block.append(board[p][q])
                if block.count(-1) == 2 and block.count(0) == 0 and len(set(block)) == 2:
                    answer += 1
                    for p in range(row, row+2):
                        for q in range(col, col+3):
                            board[p][q] = 0
                    for idx in black:
                        x, y = idx
                        board[x][y] = 0
                    black = []
                    cnt = 0
        
        for row in range(n-2):
            for col in range(n-1):
                block = []
                if board[row][col] != 0:
                    for p in range(row, row+3):
                        for q in range(col, col+2):
                            block.append(board[p][q])
                if block.count(-1) == 2 and block.count(0) == 0 and len(set(block)) == 2:
                    answer += 1
                    for p in range(row, row+3):
                        for q in range(col, col+2):
                            board[p][q] = 0
                    for idx in black:
                        x, y = idx
                        board[x][y] = 0
                    black = []
                    cnt = 0
    
    return answer


board = [[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]
print(solution(board)) # 2
