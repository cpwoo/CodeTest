import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def init():
    x, y = n//2, n//2
    dx, dy = [0,1,0,-1],[-1,0,1,0]
    depth = 0

    while True:
        for d in range(4):
            if d%2 == 0:
                depth += 1
            for _ in range(depth):
                x += dx[d]; y += dy[d]
                spread.append((x, y))
                if (x, y) == (0, 0):
                    return


def magic(d, r):
    x, y = n//2, n//2
    dx, dy = [-1,1,0,0],[0,0,-1,1]
    for _ in range(r):
        x += dx[d]; y += dy[d]
        if not (0 <= x < n and 0 <= y < n):
            break
        board[x][y] = 0

    fill()
    while bomb():
        fill()
    group()


def fill():
    blank = deque()
    for x, y in spread:
        if board[x][y] == 0:
            blank.append((x, y))
        elif board[x][y] > 0 and blank:
            nx, ny = blank.popleft()
            board[nx][ny] = board[x][y]
            board[x][y] = 0
            blank.append((x, y))


def bomb():
    visited = deque()
    cnt = 0
    num = -1
    flag = False
    for x, y in spread:
        if num == board[x][y]:
            visited.append((x, y))
            cnt += 1
        else:
            if cnt >= 4:
                score[num-1] += cnt
                flag = True
            while visited:
                nx, ny = visited.popleft()
                if cnt >= 4:
                    board[nx][ny] = 0
            
            num = board[x][y]
            cnt = 1
            visited.append((x, y))
    
    return flag


def group():
    cnt = 1
    tx, ty = spread[0]
    num = board[tx][ty]
    nums = []

    for i in range(1, len(spread)):
        x, y = spread[i]
        if num == board[x][y]:
            cnt += 1
        else:
            nums.extend([cnt, num])
            num = board[x][y]
            cnt = 1
    
    idx = 0
    for x, y in spread:
        if not nums:
            break
        board[x][y] = nums[idx]
        idx += 1
        if idx == len(nums):
            break


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
score = [0, 0, 0]

spread = deque()
init()

for _ in range(m):
    a, b = map(int, input().split())
    magic(a-1, b)

print(sum([(i+1)*score[i] for i in range(3)]))
