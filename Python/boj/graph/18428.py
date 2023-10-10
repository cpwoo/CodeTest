import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def check(x, y):
    for k in range(4):
        nx, ny = x+dx[k], y+dy[k]
        while 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] == 'X':
                nx += dx[k]
                ny += dy[k]
            elif board[nx][ny] == 'S':
                return False
            else:
                break
    return True

def dfs(count):
    if count == 3:
        flag = True
        for i in range(n):
            for j in range(n):
                if board[i][j] == 'T':
                    flag &= check(i, j)
        return flag
    
    result = False

    for i in range(n):
        for j in range(n):
            if board[i][j] == 'X':
                board[i][j] = 'O'
                result |= dfs(count+1)
                board[i][j] = 'X'
    return result


n = int(input())
board = [list(input().split()) for _ in range(n)]

print('YES' if dfs(0) else 'NO')
