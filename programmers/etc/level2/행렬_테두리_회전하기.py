def solution(rows, columns, queries):
    answer = []
    board = [[r*columns+(c+1) for c in range(columns)] for r in range(rows)]
    
    for r1, c1, r2, c2 in queries:
        r1, c1, r2, c2 = r1-1, c1-1, r2-1, c2-1
        stack = []

        for a in range(c1, c2+1):
            stack.append(board[r1][a])
            if len(stack) == 1:
                continue
            else:
                board[r1][a] = stack[-2]
        for b in range(r1+1, r2+1):
            stack.append(board[b][a])
            board[b][a] = stack[-2]
        for c in range(c2-1, c1-1, -1):
            stack.append(board[b][c])
            board[b][c] = stack[-2]
        for d in range(r2-1, r1-1, -1):
            stack.append(board[d][c])
            board[d][c] = stack[-2]
        
        answer.append(min(stack))

    return answer


rows, columns = 6, 6
queries = [[2,2,5,4],[3,3,6,6],[5,1,6,3]]
print(solution(rows, columns, queries)) # [8,10,25]

rows, columns = 3, 3
queries = [[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]
print(solution(rows, columns, queries)) # [1, 1, 5, 3]

rows, columns = 100, 97
queries = [[1,1,100,97]]
print(solution(rows, columns, queries)) # [1]
