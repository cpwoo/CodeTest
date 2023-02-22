import sys
input = lambda: sys.stdin.readline().rstrip()

R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
answer = 1

q = set()
q.add((0, 0, board[0][0]))

while q:
    x, y, ans = q.pop()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if (0 <= nx < R) and (0 <= ny < C) and board[nx][ny] not in ans:
            q.add((nx, ny, ans+board[nx][ny]))
            answer = max(answer, len(ans)+1)

print(answer)
