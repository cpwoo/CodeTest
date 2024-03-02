import sys
input = lambda: sys.stdin.readline().rstrip()

def changed(A, B):
    for i in range(n):
        for j in range(n):
            if A[i][j] != B[i][j]:
                return True
    return False


def search(v, d):
    if d == 0:
        for j in range(n):
            idx = 0
            for i in range(1, n):
                if v[i][j]:
                    x = v[i][j]
                    v[i][j] = 0
                    if v[idx][j] == 0:
                        v[idx][j] = x
                    elif v[idx][j] == x:
                        v[idx][j] *= 2
                        idx += 1
                    else:
                        idx += 1
                        v[idx][j] = x
    elif d == 1:
        for j in range(n):
            idx = n-1
            for i in range(n-2, -1, -1):
                if v[i][j]:
                    x = v[i][j]
                    v[i][j] = 0
                    if v[idx][j] == 0:
                        v[idx][j] = x
                    elif v[idx][j] == x:
                        v[idx][j] *= 2
                        idx -= 1
                    else:
                        idx -= 1
                        v[idx][j] = x
    elif d == 2:
        for i in range(n):
            idx = 0
            for j in range(1, n):
                if v[i][j]:
                    x = v[i][j]
                    v[i][j] = 0
                    if v[i][idx] == 0:
                        v[i][idx] = x
                    elif v[i][idx] == x:
                        v[i][idx] *= 2
                        idx += 1
                    else:
                        idx += 1
                        v[i][idx] = x
    elif d == 3:
        for i in range(n):
            idx = n-1
            for j in range(n-2, -1, -1):
                if v[i][j]:
                    x = v[i][j]
                    v[i][j] = 0
                    if v[i][idx] == 0:
                        v[i][idx] = x
                    elif v[i][idx] == x:
                        v[i][idx] *= 2
                        idx -= 1
                    elif v[i][idx]:
                        idx -= 1
                        v[i][idx] = x
    return v


def dfs(cnt, board):
    global ans
    
    if cnt == 10:
        val = 0
        for b in board:
            val = max(val, max(b))
    
        if ans < val:
            ans = val
            for i in range(10, -1, -1):
                value[i] = val
                val //= 2
        return

    flag = False
    for i in range(n):
        for j in range(n):
            if board[i][j] > value[cnt]:
                flag = True
                break

    if flag:
        for d in range(4):
            tmp = search([b[:] for b in board], d)
            if changed(board, tmp):
                dfs(cnt+1, tmp)
    
    return


n = int(input())
L = [list(map(int, input().split())) for _ in range(n)]
value = [0]*11

ans = 0
for i in range(n):
    ans = max(ans, max(L[i]))

dfs(0, L)

print(ans)
