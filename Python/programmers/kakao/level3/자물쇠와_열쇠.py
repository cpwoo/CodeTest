def rot90(key):
    return list(map(list, zip(*key[::-1])))

def check(board, N):
    for i in range(N):
        for j in range(N):
            if board[i+N][j+N] != 1:
                return False
    return True

def solution(key, lock):
    answer = True
    M, N = len(key), len(lock)
    board = [[1]*(3*N) for _ in range(3*N)]
    for i in range(N):
        for j in range(N):
            board[i+N][j+N] = lock[i][j]
    
    for _ in range(4):
        key = rot90(key)
        for lock_ix in range(2*N):
            for lock_iy in range(2*N):
                for key_ix in range(M):
                    for key_iy in range(M):
                        board[lock_ix+key_ix][lock_iy+key_iy] += key[key_ix][key_iy]
                if check(board, N):
                    return True
                for key_ix in range(M):
                    for key_iy in range(M):
                        board[lock_ix+key_ix][lock_iy+key_iy] -= key[key_ix][key_iy]
    return False


key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
print(solution(key, lock)) # True
