from copy import deepcopy

dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]

def dfs(graph, x, y, pos, n, num):
    ret = [pos]
    for d in range(4):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < n) and graph[nx][ny] == num:
            graph[nx][ny] = 2
            ret += dfs(graph, nx, ny, [pos[0]+dx[d], pos[1]+dy[d]], n, num)
    return ret

def rotate(arr):
    n = len(arr)
    ret = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            ret[j][n-1-i] = arr[i][j]
    return ret

def solution(game_board, table):
    answer = 0
    board_copy = deepcopy(game_board)

    n = len(game_board)
    block = []

    for i in range(n):
        for j in range(n):
            if board_copy[i][j] == 0:
                board_copy[i][j] = 2
                res = dfs(board_copy, i, j, [0, 0], n, 0)[1:]
                block.append(res)
    for _ in range(4):
        table = rotate(table)
        table_copy = deepcopy(table)
        for i in range(n):
            for j in range(n):
                if table_copy[i][j] == 1:
                    table_copy[i][j] = 2
                    res = dfs(table_copy, i, j, [0, 0], n, 1)[1:]
                    if res in block:
                        block.remove(res)
                        answer += len(res)+1
                        table = deepcopy(table_copy)
                    else:
                        table_copy = deepcopy(table)
    return answer


game_board = [[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]
table = [[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]
print(solution(game_board, table)) # 14

game_board = [[0,0,0],[1,1,0],[1,1,1]]
table = [[1,1,1],[1,0,0],[0,0,0]]
print(solution(game_board, table)) # 0
