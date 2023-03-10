import sys
def input(): return sys.stdin.readline().rstrip()

from collections import deque

def check():
    visited = [[False]*5 for _ in range(5)]
    for idx in arr:
        visited[idx//5][idx%5] = True
    
    q = deque([arr[0]])
    direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    depth = 0
    visited[arr[0]//5][arr[0]%5] = False

    while q:
        idx = q.popleft()
        depth += 1
        y, x = idx//5, idx%5

        for dy, dx in direction:
            ny, nx = y+dy, x+dx
            if (0 <= ny < 5) and (0 <= nx < 5) and visited[ny][nx]:
                visited[ny][nx] = False
                q.append((5 * ny) + nx)

    if depth == 7:
        return True
    else:
        return False


def dfs(depth, idx, s_cnt, y_cnt):
    global cnt

    if depth == 7 and s_cnt >= 4:
        if check():
            cnt += 1
        return

    if y_cnt >= 4 or idx >= 25 or depth > 7:
        return

    y, x = idx//5, idx%5

    arr.append(idx)
    if board[y][x] == "Y":
        dfs(depth+1, idx+1, s_cnt, y_cnt+1)
    elif board[y][x] == "S":
        dfs(depth+1, idx+1, s_cnt+1, y_cnt)
    arr.pop()
    dfs(depth, idx+1, s_cnt, y_cnt)


board = [list(input()) for _ in range(5)]
cnt, arr = 0, []

dfs(0, 0, 0, 0)
print(cnt)
