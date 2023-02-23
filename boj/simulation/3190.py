import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def change(d, c):
    if c == "L":
        d = (d-1)%4
    else:
        d = (d+1)%4
    return d

# 상 우 하 좌
dy, dx = [-1, 0, 1, 0], [0, 1, 0, -1]

def solution():
    direction = 1
    time = 1
    y, x = 0, 0
    visited = deque()
    visited.append([y, x])
    board[y][x] = 2
    while True:
        ny, nx = y+dy[direction], x+dx[direction]
        if (0 <= ny < N) and (0 <= nx < N) and board[ny][nx] != 2:
            if board[ny][nx] == 0:
                ty, tx = visited.popleft()
                board[ty][tx] = 0
            board[ny][nx] = 2
            visited.append([ny, nx])
            if time in times.keys():
                direction = change(direction, times[time])
            time += 1
            y, x = ny, nx
        else:
            return time


N, K = int(input()), int(input()) 

board = [[0]*N for _ in range(N)]

for _ in range(K):
    y, x = map(int, input().split())
    board[y-1][x-1] = 1

L = int(input())
times = {}

for _ in range(L):
    t, c = input().split()
    times[int(t)] = c

print(solution())
