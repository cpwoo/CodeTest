import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

def up(board):
    for j in range(n):
        pointer = 0
        for i in range(1, n):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[pointer][j] == 0:
                    board[pointer][j] = tmp
                elif board[pointer][j] == tmp:
                    board[pointer][j] *= 2
                    pointer += 1
                else:
                    pointer += 1
                    board[pointer][j] = tmp
    return board

def down(board):
    for j in range(n):
        pointer = n-1
        for i in range(n-2, -1, -1):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[pointer][j] == 0:
                    board[pointer][j] = tmp
                elif board[pointer][j] == tmp:
                    board[pointer][j] *= 2
                    pointer -= 1
                else:
                    pointer -= 1
                    board[pointer][j] = tmp
    return board

def left(board):
    for i in range(n):
        pointer = 0
        for j in range(1, n):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[i][pointer] == 0:
                    board[i][pointer] = tmp
                elif board[i][pointer] == tmp:
                    board[i][pointer] *= 2
                    pointer += 1
                else:
                    pointer += 1
                    board[i][pointer] = tmp
    return board

def right(board):
    for i in range(n):
        pointer = n-1
        for j in range(n-2, -1, -1):
            if board[i][j]:
                tmp = board[i][j]
                board[i][j] = 0
                if board[i][pointer] == 0:
                    board[i][pointer] = tmp
                elif board[i][pointer] == tmp:
                    board[i][pointer] *= 2
                    pointer -= 1
                else:
                    pointer -= 1
                    board[i][pointer] = tmp
    return board

ans = 0
def dfs(cnt, arr):
    global ans
    if cnt == 5:
        for i in range(n):
            for j in range(n):
                if arr[i][j] > ans:
                    ans = arr[i][j]
        return

    for i in range(4):
        copy_arr = deepcopy(arr)
        if i == 0:
            dfs(cnt+1, left(copy_arr))
        elif i == 1:
            dfs(cnt+1, right(copy_arr))
        elif i == 2:
            dfs(cnt+1, up(copy_arr))
        else:
            dfs(cnt+1, down(copy_arr))


n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

dfs(0, board)
print(ans)
