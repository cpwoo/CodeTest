import sys
input = lambda: sys.stdin.readline().rstrip()

def check(y, x, size):
    for i in range(y, y+size+1):
        for j in range(x, x+size+1):
            if not board[i][j]: return False
    return True

def backtracking(y, x, cnt):
    global answer
    
    if y >= 10:
        answer = min(answer, cnt)
        return
    if x >= 10:
        backtracking(y+1, 0, cnt)
        return
    
    if board[y][x] == 1:
        for k in range(5):
            if papers[k] == 5:
                continue
            if y+k >= 10 or x+k >= 10:
                continue
            
            flag = check(y, x, k)
            
            if flag:
                for i in range(y, y+k+1):
                    for j in range(x, x+k+1):
                        board[i][j] = 0
                papers[k] += 1
                backtracking(y, x+k+1, cnt+1)
                papers[k] -= 1
                for i in range(y, y+k+1):
                    for j in range(x, x+k+1):
                        board[i][j] = 1
    else:
        backtracking(y, x+1, cnt)


board = [list(map(int, input().split())) for _ in range(10)]
papers = [0, 0, 0, 0, 0]

answer = 26
backtracking(0, 0, 0)

print(answer if answer != 26 else -1)
