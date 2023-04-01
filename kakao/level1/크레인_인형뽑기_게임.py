def solution(board, moves):
    answer = 0
    tmp = []
    L = len(board)
    for m in moves:
        for i in range(L):
            if board[i][m-1] != 0:
                tmp.append(board[i][m-1])
                board[i][m-1] = 0
                break
        
        if len(tmp) > 1 and tmp[-1] == tmp[-2]:
            tmp = tmp[:-2]
            answer += 2

    return answer


board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves = [1,5,3,5,1,2,1,4]
print(solution(board, moves)) # 4
