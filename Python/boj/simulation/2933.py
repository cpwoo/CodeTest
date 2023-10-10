import sys
input = lambda: sys.stdin.readline().rstrip()

dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]

def remove_mineral(i, j):
    stack = [[i, j]]
    while stack:
        node = stack.pop()
        board_copy[node[0]][node[1]] = True
        for di, dj in zip(dy, dx):
            ni, nj = node[0]+di, node[1]+dj
            if not (0 <= ni < n and 0 <= nj < m): continue
            if not board_copy[ni][nj]: stack.append([ni, nj])


def air_mineral():
    air_dict = dict()
    for i in range(n):
        for j in range(m):
            if not board_copy[i][j]:
                if j in air_dict.keys():
                    air_dict[j].append(i)
                else:
                    air_dict[j] = [i]
    return air_dict


n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
shoot = int(input())
shoot_list = list(map(lambda x: n-int(x), input().split()))
board_copy = [[False]*m for _ in range(n)]

for order in range(len(shoot_list)):
    y = shoot_list[order]
    T = 0

    if order%2 == 0:
        for x in range(m):
            if board[y][x] == 'x':
                board[y][x] = '.'
                T = 1
                break

    elif order%2 == 1:
        for x in range(m-1, -1, -1):
            if board[y][x] == 'x':
                board[y][x] = '.'
                T = 1
                break
    
    if T == 1:
        for i in range(n):
            for j in range(m):
                if board[i][j] == '.':
                    board_copy[i][j] = True
                else:
                    board_copy[i][j] = False
            
        for col in range(m):
            if not board_copy[-1][col]:
                remove_mineral(n-1, col)

        air_cluster = air_mineral()

        if air_cluster:
            minv = 100
            for x in air_cluster.keys():
                for y in air_cluster[x]:
                    for fy in range(y+1, n):
                        if board[fy][x] == 'x' and fy not in air_cluster[x]:
                            minv = min(minv, fy-y-1)
                    if fy == n-1 and board[fy][x] == '.':
                        minv = min(minv, fy-y)
                
            for x in air_cluster.keys():
                air_cluster[x].sort(reverse=True)
                for y in air_cluster[x]:
                    board[y][x] = '.'
                    board[y+minv][x] = 'x'

for row in board:
    print(''.join(row))
