import sys
input = lambda: sys.stdin.readline().rstrip()

dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]

A, B = map(int, input().split())
N, M = map(int, input().split())

board = [[0]*A for _ in range(B)]

d = {'N':0, 'E':1, 'S':2, 'W':3}
robot = dict()

for i in range(1, N+1):
    x, y, dir = input().split()
    board[B-int(y)][int(x)-1] = 1
    robot[i] = [B-int(y), int(x)-1, d[dir]]


for _ in range(M):
    target, command, repeat = input().split()
    target, repeat = int(target), int(repeat)
    
    for _ in range(repeat):
        if command == "F":
            y, x, direction = robot[target]
            ny, nx = y+dy[direction], x+dx[direction]

            if not (0 <= ny < B and 0 <= nx < A):
                print("Robot", target, "crashes into the wall")
                exit()
            elif board[ny][nx] == 1:
                for i in robot:
                    if (ny, nx) == (robot[i][0], robot[i][1]):
                        print("Robot", target, "crashes into robot", i)
                        exit()
            else:
                board[y][x] = 0
                board[ny][nx] = 1
                robot[target][0] = ny
                robot[target][1] = nx
        elif command == "L":
            robot[target][2] = (robot[target][2]-1)%4
        else:
            robot[target][2] = (robot[target][2]+1)%4
print("OK")
