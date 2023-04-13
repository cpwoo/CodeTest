moves = ((0, 1), (-1, 0), (1, 0), (0, -1))

def game(board, aloc, bloc):
    game_results = []

    if board[bloc[0]][bloc[1]] == 0:
        return True, 0
    if board[aloc[0]][aloc[1]] == 0:
        return False, 0

    for move in moves:
        next_aloc = (aloc[0]+move[0], aloc[1]+move[1])
        try:
            if next_aloc[0] < 0 or next_aloc[1] < 0:
                raise IndexError
            next_board = board[next_aloc[0]][next_aloc[1]]
        except IndexError:
            continue

        if next_board == 1:
            board[aloc[0]][aloc[1]] = 0
            win, game_length = game(board, bloc, next_aloc)
            board[aloc[0]][aloc[1]] = 1
            game_results.append((not win, game_length+1))

    if len(game_results) == 0:
        return False, 0
    elif any(r[0] for r in game_results):
        return True, min(r[1] for r in game_results if r[0])
    else:
        return False, max(r[1] for r in game_results)

def solution(board, aloc, bloc):
    return game(board, aloc, bloc)[1]


board = [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
aloc, bloc = [1, 0], [1, 2]
print(solution(board, aloc, bloc)) # 5

board = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
aloc, bloc = [1, 0], [1, 2]
print(solution(board, aloc, bloc)) # 4

board = [[1, 1, 1, 1, 1]]
aloc, bloc = [0, 0], [0, 4]
print(solution(board, aloc, bloc)) # 4

board = [[1]]
aloc, bloc = [0, 0], [0, 0]
print(solution(board, aloc, bloc)) # 0
